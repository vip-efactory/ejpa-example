package vip.efactory.ejpa.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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
