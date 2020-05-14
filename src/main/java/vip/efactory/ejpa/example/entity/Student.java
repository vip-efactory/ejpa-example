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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生表，用来测试接口是否正常
 * 对于校验注解，没有指定groups属性的，则默认是Default.class组，
 * 控制器里在save方法是使用默认组，
 * updateById,使用Update.class组,更新时允许部分字段为空，但是若有值则校验属性值的合法性
 */
@Setter
@Getter
@Entity
public class Student extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id {property.not.allow.empty}", groups = Update.class)  // 意味着，updateById更新时id不允许为空
    @Column(name = "student_id", unique = true)
    private Long id;

    // 不论新增和更新都应符合要求
    @Length(min = 4, max = 8, message = "{Student.name} {property.length.in.between}", groups = {Update.class, Default.class})
    // 意思是，新增时不允许为空，updateById更新时可为空！
    @NotBlank(message = "{Student.name} {property.not.allow.empty}")
    private String name;

    @Range(min = 0, max = 2, message = "{Student.sex} {property.value.in.range}", groups = {Update.class, Default.class})
    private Integer sex;    // 0 未知；1 男；2 女

    @PositiveOrZero(message = "{Student.age} {property.not.allow.negative}", groups = {Update.class, Default.class})
    private Integer age;

    /**
     * 爱好,测试不使用国际化文件，直接硬编码返回！
     */
    @NotBlank(message = "爱好属性信息不允许为空")
    private String hobby;

    /**
     * 身高，单位cm，例如:180.6cm
     */
    @Max(value = 300, message = "{Student.height}{property.value.should.lt.max}", groups = {Update.class, Default.class})
    private Double height;

    @Email(message = "{Student.email}{property.format.error}", groups = {Update.class, Default.class})
    private String email;

    @Past(message = "{Student.birthday}{property.value.only.past}", groups = {Update.class, Default.class})
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToMany(targetEntity = Teacher.class)
    @JoinTable(
            name = "tbl_stu_teacher",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", unique = true)
    )
    private Set<Teacher> teachers = new HashSet<>(); // 一个学生关联多个老师
}
