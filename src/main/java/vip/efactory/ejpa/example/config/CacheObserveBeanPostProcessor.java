package vip.efactory.ejpa.example.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vip.efactory.ejpa.example.service.impl.CourseServiceImpl;
import vip.efactory.ejpa.example.service.impl.TeacherServiceImpl;

import javax.annotation.PostConstruct;

/**
 * Description: 统一处理缓存观察者模式的。避免局部处理的循环引用
 *
 * @Author dbdu
 * @Date 2020-08-24
 */
@AllArgsConstructor
@Component
@Slf4j
public class CacheObserveBeanPostProcessor {
    // course ，teacher组件的缓存处理
    CourseServiceImpl courseServiceImpl;
    TeacherServiceImpl teacherServiceImpl;


    private void init4course() {
        log.info("开始注册course的观察者...");
        courseServiceImpl.registObservers(teacherServiceImpl);
    }

    @PostConstruct
    private void initCacheObserve() {
        init4course();
    }
}
