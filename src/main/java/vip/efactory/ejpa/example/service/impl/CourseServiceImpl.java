package vip.efactory.ejpa.example.service.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.Course;
import vip.efactory.ejpa.example.repository.CourseRepository;
import vip.efactory.ejpa.example.service.ICourseService;

import java.util.*;

/**
 * @author dbdu
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepository> implements ICourseService {

    // 以下这些方法都是不变更数据的查询方法，若为了提高并发性能，可以尽可能的加持缓存   ----开始
    @Override
    public Iterable<Course> findAll() {
        return super.findAll();
    }

    @Override
    public Page<Course> findAll(Pageable var1) {
        return super.findAll(var1);
    }

    @Override
    public Iterable<Course> findAll(Sort var1) {
        return super.findAll(var1);
    }

    @Override
    public Iterable<Course> findAllById(Iterable<Long> var1) {
        return super.findAllById(var1);
    }

    @Override
    public Course getOne(Long aLong) {
        return super.getOne(aLong);
    }

    @Override
    public Optional<Course> findById(Long var1) {
        return super.findById(var1);
    }

    @Override
    public <S extends Course> Optional<S> findOne(Example<S> example) {
        return super.findOne(example);
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> var1) {
        return super.findAll(var1);
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> var1, Sort var2) {
        return super.findAll(var1, var2);
    }

    @Override
    public <S extends Course> Page<S> findAll(Example<S> example, Pageable pageable) {
        return super.findAll(example, pageable);
    }

    @Override
    public void flush() {
        super.flush();
    }

    @Override
    public boolean existsById(Long var1) {
        return super.existsById(var1);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public <S extends Course> long count(Example<S> example) {
        return super.count(example);
    }

    @Override
    public <S extends Course> boolean exists(Example<S> example) {
        return super.exists(example);
    }

    @Override
    public boolean existsByEntityProperty(String propertyName, String propertyValue) throws NoSuchFieldException {
        return super.existsByEntityProperty(propertyName, propertyValue);
    }

    @Override
    public List<Course> advancedQuery(Course entity) {
        return super.advancedQuery(entity);
    }

    @Override
    public Page<Course> advancedQuery(Course entity, Pageable pageable) {
        return super.advancedQuery(entity, pageable);
    }

    @Override
    public Set advanceSearchProperty(String property, String value) {
        return super.advanceSearchProperty(property, value);
    }
    // 以上这些方法都是不变更数据的查询方法，若为了提高并发性能，可以尽可能的加持缓存   ----结束


    // 以下是涉及到数据库变更的所有方法开始，这些方法不仅要维护自身的缓存，还要通知哪些依赖并观察自己的观察者去更新他们的缓存
    @Override
    public <S extends Course> Iterable<S> saveAll(Iterable<S> var1) {
        return super.saveAll(var1);
    }

    @Override
    public <S extends Course> S saveAndFlush(S var1) {
        return super.saveAndFlush(var1);
    }

    @Override
    public <S extends Course> S save(S var1) {
        return super.save(var1);
    }

    @Override
    public void delete(Course var1) {
        super.delete(var1);
    }

    @Override
    public void deleteById(Long var1) {
        super.deleteById(var1);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends Course> var1) {
        super.deleteAll(var1);
    }

    @Override
    public void deleteAllInBatch() {
        super.deleteAllInBatch();
    }

    @Override
    public void deleteInBatch(Iterable<Course> var1) {
        super.deleteInBatch(var1);
    }

    @Override
    public int deleteAllById(Iterable<Long> var1) {
        return super.deleteAllById(var1);
    }

    @Override
    public <S extends Course> S update(S var1) {
        return super.update(var1);
    }
    // 以上是涉及到数据库变更的所有方法      --------结束

    // 以下这些方法是处理关联缓存一致性的 不过因为本组件仅被别人依赖而不依赖别人，所以只需要被观察不需要观察别人 ----开始

    @Override
    public void registObservers(Observer... observers) {
        super.registObservers(observers);
    }

    @Override
    public void notifyOthers(Object arg) {
        super.notifyOthers(arg);
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
    }


    // 以下这些方法是处理关联缓存一致性的 不过因为本组件仅被别人依赖而不依赖别人，所以只需要被观察不需要观察别人 ----结束

}
