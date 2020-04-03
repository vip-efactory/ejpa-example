package vip.efactory.ejpa.example.config;

import org.hibernate.FlushMode;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.tool.schema.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import vip.efactory.ejpa.config.tenant.ds.MultiTenantConnectionProviderImpl;
import vip.efactory.ejpa.config.tenant.ds.MultiTenantIdentifierResolver;
import vip.efactory.ejpa.config.tenant.ds.TenantDataSourceProvider;
import vip.efactory.ejpa.example.entity.SystemTenant;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({MultiTenantDataSourceProperties.class, JpaProperties.class})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(
        basePackages = {"vip.efactory.ejpa.example.repository"},
        transactionManagerRef = "txManager")
public class MultiTenantJpaConfiguration {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private MultiTenantDataSourceProperties multiTenantDataSourceProperties;

    /**
     * 初始化所有租户的数据源
     */
    @PostConstruct
    public void initDataSources() {
        for (MultiTenantDataSourceProperties.DataSourceProperties dsProperties : this.multiTenantDataSourceProperties.getDataSourcesProps()) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create()
                    .url(dsProperties.getUrl())
                    .username(dsProperties.getUsername())
                    .password(dsProperties.getPassword())
                    .driverClassName(dsProperties.getDriverClassName());
            TenantDataSourceProvider.addDataSource(dsProperties.getTenantId(), factory.build());  // 放入数据源集合中
        }
    }

    @Bean
    public MultiTenantConnectionProvider multiTenantConnectionProvider() {
        return new MultiTenantConnectionProviderImpl();
    }

    @Bean
    public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
        return new MultiTenantIdentifierResolver();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(MultiTenantConnectionProvider multiTenantConnectionProvider,
                                                                           CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {

        Map<String, Object> hibernateProps = new LinkedHashMap<>();
        hibernateProps.putAll(this.jpaProperties.getProperties());
        hibernateProps.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
        hibernateProps.put(Environment.PHYSICAL_NAMING_STRATEGY, "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy"); //属性及column命名策略
        hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
        hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);
        hibernateProps.put(Environment.HBM2DDL_AUTO, Action.UPDATE);  // 自动建表

        // No dataSource is set to resulting entityManagerFactoryBean
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();

        result.setPackagesToScan(new String[]{SystemTenant.class.getPackage().getName()});
        result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        result.setJpaPropertyMap(hibernateProps);

        return result;
    }

    @Bean
    @Primary  // 注意我们自己定义的bean，最好都加此注解，防止与自动配置的重复而不知道如何选择
    public EntityManagerFactory entityManagerFactory(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return entityManagerFactoryBean.getObject();
    }

    @Bean
    @Primary  // 注意我们自己定义的bean，最好都加此注解，防止与自动配置的重复而不知道如何选择
    public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        HibernateTransactionManager result = new HibernateTransactionManager();
        result.setAutodetectDataSource(false);   // 不自动检测数据源
        result.setSessionFactory(sessionFactory);
        result.setRollbackOnCommitFailure(true);
        return result;
    }

}
