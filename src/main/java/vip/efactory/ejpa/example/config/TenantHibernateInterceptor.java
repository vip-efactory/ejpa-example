package vip.efactory.ejpa.example.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.type.Type;
import vip.efactory.ejpa.tenant.column.TenantBaseEntity;
import vip.efactory.ejpa.tenant.identifier.TenantHolder;

import java.io.Serializable;

/**
 * 重写hibernate的空拦截器的实现，对所有的实体操作都要进行租户条件过滤
 */
@Slf4j
public class TenantHibernateInterceptor extends EmptyInterceptor {

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantBaseEntity) {
            log.debug("[load] Updating the entity " + id + " with tenant information: " + TenantHolder.getTenantId());
            ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
        }
        return false;
    }

    /**
     * 新增时为租户字段赋值
     */
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantBaseEntity) {
            log.debug("[save] Updating the entity " + id + " with tenant information: " + TenantHolder.getTenantId());
            ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
        }
        return false;
    }

    /**
     * 删除时依据租户字段进行过滤
     */
    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantBaseEntity) {
            log.debug("[delete] Updating the entity " + id + " with tenant information: " + TenantHolder.getTenantId());
            ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
        }
    }

//    @Override
//    public void preFlush(Iterator entities) {
//        entities.forEachRemaining(entity -> {
//            if (entity instanceof TenantBaseEntity) {
//                log.debug("[pre-flush] Updating the entity with tenant information: " + TenantHolder.getTenantId());
//                ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
//            }
//        });
//    }

    /**
     * 清空flush时
     */
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantBaseEntity) {
            log.debug("[flush-dirty] Updating the entity " + id + " with tenant information: " + TenantHolder.getTenantId());
            ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
        }
        return false;
    }

//    @Override
//    public void postFlush(Iterator entities) {
//        entities.forEachRemaining(entity -> {
//            if (entity instanceof TenantBaseEntity) {
//                log.debug("[post-flush] Updating the entity with tenant information: " + TenantHolder.getTenantId());
//                ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
//            }
//        });
//    }


    @Override
    public Boolean isTransient(Object entity) {
        if (entity instanceof TenantBaseEntity) {
            log.debug("[is-transient] Updating the entity with tenant information: " + TenantHolder.getTenantId());
            ((TenantBaseEntity) entity).setTenantId(TenantHolder.getTenantId());
        }
        return null;
    }

    @Override
    public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
        return null;
    }

    @Override
    public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        return null;
    }

    @Override
    public String getEntityName(Object object) {
        return null;
    }

    @Override
    public Object getEntity(String entityName, Serializable id) {
        return null;
    }

    @Override
    public String onPrepareStatement(String sql) {
        return sql;
    }

    @Override
    public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
    }

    @Override
    public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
    }

    @Override
    public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
    }

}
