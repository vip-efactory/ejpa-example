package vip.efactory.ejpa.example.entity;

import lombok.Getter;
import lombok.Setter;
import vip.efactory.ejpa.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@Entity
public class Student extends BaseEntity<Long> {

    @Id
    private Long id;

    private String name;

    private int sex;    // 0 未知；1 男；2 女

    private int age;

    private Date birthday;

}
