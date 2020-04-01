package vip.efactory.ejpa.example.entity;

import lombok.Getter;
import lombok.Setter;
import vip.efactory.ejpa.base.entity.TenantEntity;
import vip.efactory.ejpa.base.valid.Update;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 学生表，用来测试接口是否正常
 * 对于校验注解，没有指定groups属性的，则默认是Default.class组，
 * 控制器里在save方法是使用默认组，
 * updateById,使用Update.class组,更新时允许部分字段为空，但是若有值则校验属性值的合法性
 */
@Setter
@Getter
@Entity
public class SystemTenant extends TenantEntity<Long> {

    /**
     * 租户ID，也是主键，默认为0L
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "id {property.not.allow.empty}", groups = Update.class)  // 意味着，updateById更新时id不允许为空
    private Long id;

}
