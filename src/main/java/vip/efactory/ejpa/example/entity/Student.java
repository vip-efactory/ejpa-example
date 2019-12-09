package vip.efactory.ejpa.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import vip.efactory.ejpa.base.entity.BaseEntity;

import javax.persistence.*;
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

    private String name;

    private Integer sex;    // 0 未知；1 男；2 女

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    private Date birthday;

}
