package vip.efactory.ejpa.example.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import vip.efactory.ejpa.config.tenant.id.TenantHolder;

import javax.persistence.EntityManager;

/**
 * 多租户字段的数据条件过滤，适用于基于字段的多租户模式。
 */
@Aspect
@Component
@Slf4j
public class TenantColumnAspect {

    /**
     * 在获取Hibernate的Session之后启用租户过滤器。
     *
     * @param joinPoint
     * @param retVal
     */
    @AfterReturning(pointcut = "bean(entityManagerFactory) && execution(* createEntityManager(..))", returning = "retVal")
    public void getSessionAfter(JoinPoint joinPoint, Object retVal) {
        if (retVal != null && EntityManager.class.isInstance(retVal)) {
            Session session = ((EntityManager) retVal).unwrap(Session.class);
            session.enableFilter("tenantJpaFilter").setParameter("tenantId", TenantHolder.getTenantId());
        }
    }


}
