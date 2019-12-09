package vip.efactory.ejpa.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // 创建时间、创建人等字段的处理
@SpringBootApplication
public class EjpaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjpaExampleApplication.class, args);
    }

}
