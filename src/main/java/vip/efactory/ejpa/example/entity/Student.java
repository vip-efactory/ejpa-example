package vip.efactory.ejpa.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import vip.efactory.ejpa.base.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
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

    @Range(min = 0, max = 2, message = "{student.sex} {property.length.in.between}")
    private Integer sex;    // 0 未知；1 男；2 女

    @PositiveOrZero(message = "{student.age} {property.not.allow.negative}")
    private Integer age;

    /**
     * 爱好
     */
    private String hobby;

    @Email(message = "{student.email}{property.format.error}")
    private String email;

    @Past(message = "{student.birthday}{property.value.only.past}")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    private Date birthday;

}
