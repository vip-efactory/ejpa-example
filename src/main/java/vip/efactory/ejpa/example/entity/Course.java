package vip.efactory.ejpa.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import vip.efactory.ejpa.base.entity.BaseEntity;
import vip.efactory.ejpa.base.valid.Update;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 学科表，用来测试接口是否正常
 * 对于校验注解，没有指定groups属性的，则默认是Default.class组，
 * 控制器里在save方法是使用默认组，
 * updateById,使用Update.class组,更新时允许部分字段为空，但是若有值则校验属性值的合法性
 */
@Setter
@Getter
@Entity
public class Course extends BaseEntity<Long> {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id {property.not.allow.empty}", groups = Update.class)  // 意味着，updateById更新时id不允许为空
    private Long id;

    // 不论新增和更新都应符合要求
    @Length(min = 2, max = 32, groups = {Update.class, Default.class})
    // 意思是，新增时不允许为空，updateById更新时可为空！
    @NotBlank
    private String name;

    // 时长，例如：30 课时
    @Range(min = 0, max = 150, groups = {Update.class, Default.class})
    private Integer duration;

    // 学费 ，例如 3500.40元
    @PositiveOrZero
    private BigDecimal coins;

    // 本期课程开设日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToOne(targetEntity = Teacher.class,mappedBy = "course")
    private Teacher teacher;

}
