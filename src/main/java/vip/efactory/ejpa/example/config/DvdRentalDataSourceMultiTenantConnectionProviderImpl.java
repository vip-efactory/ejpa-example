//package vip.efactory.ejpa.example.config;
//
//import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//public class DvdRentalDataSourceMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
//    //...
//    @Autowired
//    private Map<String, DataSource> dataSourcesDvdRental;
//
//    @Override
//    protected DataSource selectAnyDataSource() {
//        return this.dataSourcesDvdRental.values().iterator().next();
//    }
//
//    @Override
//    protected DataSource selectDataSource(String tenantIdentifier) {
//        return this.dataSourcesDvdRental.get(tenantIdentifier);
//    }
//    // ...
//}
