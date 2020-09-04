package vip.efactory.ejpa.example.entity;

import lombok.Getter;
import lombok.Setter;
import vip.efactory.common.base.valid.Update;
import vip.efactory.ejpa.base.entity.TenantEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 多租户表，用来管理系统中的多租户数据源信息
 */
@Setter
@Getter
@Entity
public class SysTenant extends TenantEntity<Long> {

    /**
     * 租户ID，也是主键，默认为0L
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id {property.not.allow.empty}", groups = Update.class)  // 意味着，updateById更新时id不允许为空
    private Long id;

    /**
     * 租户状态: 0 --正常可用；1--禁用；
     */
    private Integer status;
}
