package vip.efactory.ejpa.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import vip.efactory.common.base.valid.Update;
import vip.efactory.ejpa.base.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;

/**
 * 教师表，用来测试接口是否正常
 * 对于校验注解，没有指定groups属性的，则默认是Default.class组，
 * 控制器里在save方法是使用默认组，
 * updateById,使用Update.class组,更新时允许部分字段为空，但是若有值则校验属性值的合法性
 */
@Setter
@Getter
@Entity
public class Teacher extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id {property.not.allow.empty}", groups = Update.class)  // 意味着，updateById更新时id不允许为空
    private Long id;

    // 不论新增和更新都应符合要求
    @Length(min = 2, max = 32, message = "{Student.name} {property.length.in.between}", groups = {Update.class, Default.class})
    // 意思是，新增时不允许为空，updateById更新时可为空！
    @NotBlank
    private String name;

    @PositiveOrZero(groups = {Update.class, Default.class})
    private Integer age;

    @Email(groups = {Update.class, Default.class})
    private String email;

    @Past(groups = {Update.class, Default.class})
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "id", unique = true)
    private Course course; // 一个老师关联一个们学科

}
