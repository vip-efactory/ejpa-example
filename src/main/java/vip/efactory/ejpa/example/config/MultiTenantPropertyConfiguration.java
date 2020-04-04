package vip.efactory.ejpa.example.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.schema.Action;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties({JpaProperties.class})
public class MultiTenantPropertyConfiguration {

    /**
     * 实体租户列字段持久层处理的拦截器
     */
    public EmptyInterceptor hibernateInterceptor() {
        return new TenantHibernateInterceptor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factory, DataSource dataSource, JpaProperties properties) {
        Map<String, Object> hibernateProps = new HashMap<>();
        hibernateProps.putAll(properties.getProperties());
        hibernateProps.put(Environment.INTERCEPTOR, hibernateInterceptor());  // 租户属性处理的拦截器，为租户的属性赋值
        hibernateProps.put(Environment.PHYSICAL_NAMING_STRATEGY, "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy"); //属性及column命名策略
        hibernateProps.put(Environment.SHOW_SQL, true);     // 显示SQL
        hibernateProps.put(Environment.FORMAT_SQL, true);   // 格式化SQL
        hibernateProps.put(Environment.HBM2DDL_AUTO, Action.UPDATE);    // 更新表结构

        return factory.dataSource(dataSource).packages("vip.efactory").properties(hibernateProps).build();
    }

}
