package vip.efactory.ejpa.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "multitenancy")
public class MultiTenantDataSourceProperties {
    @Setter
    @Getter
    private List<DataSourceProperties> dataSourcesProps;

    public static class DataSourceProperties extends org.springframework.boot.autoconfigure.jdbc.DataSourceProperties {

        @Setter
        @Getter
        private String tenantId;
    }
}
