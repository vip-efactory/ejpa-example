//package vip.efactory.ejpa.example.config;
//
//import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
//
//public class TenantDvdRentalIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
//
//    private static String DEFAULT_TENANT_ID = "1";
//
//    @Override
//    public String resolveCurrentTenantIdentifier() {
//        String currentTenantId = DvdRentalTenantContext.getTenantId();
//        return (currentTenantId != null) ? currentTenantId : DEFAULT_TENANT_ID;
//    }
//
//}
