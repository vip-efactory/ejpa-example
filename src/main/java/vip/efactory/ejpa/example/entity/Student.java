package vip.efactory.ejpa.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import vip.efactory.ejpa.base.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * 学生表，用来测试接口是否正常
 */
@Setter
@Getter
@Entity
public class Student extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min = 4, max = 8, message = "{student.name} {property.length.in.between}")
    @NotBlank(message = "{student.name} {property.not.allow.empty}")
    private String name;

    @Range(min = 0, max = 2, message = "{student.sex} {property.value.in.range}")
    private Integer sex;    // 0 未知；1 男；2 女

    @PositiveOrZero(message = "{student.age} {property.not.allow.negative}")
    private Integer age;

    /**
     * 爱好,测试不使用国际化文件，直接硬编码返回！
     */
    @NotBlank(message = "爱好属性信息不允许为空")
    private String hobby;

    /**
     * 身高，单位cm，例如:180.6cm
     */
    @Max(value = 300, message = "{student.height}{property.value.should.lt.max}")
    private Double height;

    @Email(message = "{student.email}{property.format.error}")
    private String email;

    @Past(message = "{student.birthday}{property.value.only.past}")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    private Date birthday;

}
