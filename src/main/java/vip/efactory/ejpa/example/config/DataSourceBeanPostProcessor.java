package vip.efactory.ejpa.example.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;
import vip.efactory.ejpa.config.tenant.ds.TenantDataSourceProvider;
import vip.efactory.ejpa.example.entity.SysTenant;
import vip.efactory.ejpa.example.service.ISysTenantService;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * 此处这么写是为了破解循环引用,MultiTenantJpaConfiguration与ISystemTenantService相互依赖
 */
@AllArgsConstructor
@Component
@Slf4j
public class DataSourceBeanPostProcessor {
    private ISysTenantService tenantService;

    @PostConstruct
    public void init() {
        // 获取数据库里所有的租户信息
        log.info("多租户的数据源初始化开始...");
        List<SysTenant> tenantList = (List<SysTenant>) tenantService.findAll();
        // 初始化所有租户的数据源
        tenantList.forEach(tenant -> {
            DataSource dataSource = DataSourceBuilder.create()
                    .url(tenant.getJdbcUrl())
                    .username(tenant.getDbUsername())
                    .password(tenant.getDbPassword())
                    .driverClassName(tenant.getDriverClassName())
                    .build();
            TenantDataSourceProvider.addDataSource(tenant.getId().toString(), dataSource);  // 放入数据源集合中
            log.info("租户{}的数据源初始化完成！", tenant.getId());
        });
        log.info("多租户的数据源初始化结束");
    }

}
