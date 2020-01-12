package vip.efactory.ejpa.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import vip.efactory.common.i18n.enums.Entityi18nUtil;
import vip.efactory.ejpa.base.entity.BaseEntity;
import vip.efactory.ejpa.example.entity.Student;

import java.util.LinkedList;
import java.util.List;

@EnableJpaAuditing  // 创建时间、创建人等字段的处理
@SpringBootApplication
public class EjpaExampleApplication {

    public static void main(String[] args) {
//        List<Class> classes = new LinkedList<>();
//        classes.add(BaseEntity.class);
//        classes.add(Student.class);
//        Entityi18nUtil.copyToLocale(Entityi18nUtil.geni18nPropertiesFile("messages", classes));
        SpringApplication.run(EjpaExampleApplication.class, args);
    }

}
