package vip.efactory.ejpa.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.Teacher;
import vip.efactory.ejpa.example.repository.TeacherRepository;
import vip.efactory.ejpa.example.service.ITeacherService;

import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.Set;

/**
 * @author dbdu
 */
@Service
@Slf4j
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Long, TeacherRepository> implements ITeacherService {
    // 以下这些方法都是不变更数据的查询方法，若为了提高并发性能，可以尽可能的加持缓存   ----开始

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Iterable<Teacher> findAll() {
        return super.findAll();
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Page<Teacher> findAll(Pageable var1) {
        return super.findAll(var1);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Iterable<Teacher> findAll(Sort var1) {
        return super.findAll(var1);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Iterable<Teacher> findAllById(Iterable<Long> var1) {
        return super.findAllById(var1);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Teacher getOne(Long aLong) {
        return super.getOne(aLong);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Optional<Teacher> findById(Long var1) {
        return super.findById(var1);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public <S extends Teacher> Optional<S> findOne(Example<S> example) {
        return super.findOne(example);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public <S extends Teacher> List<S> findAll(Example<S> var1) {
        return super.findAll(var1);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public <S extends Teacher> List<S> findAll(Example<S> var1, Sort var2) {
        return super.findAll(var1, var2);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public <S extends Teacher> Page<S> findAll(Example<S> example, Pageable pageable) {
        return super.findAll(example, pageable);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public boolean existsById(Long var1) {
        return super.existsById(var1);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public long count() {
        return super.count();
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public <S extends Teacher> long count(Example<S> example) {
        return super.count(example);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public <S extends Teacher> boolean exists(Example<S> example) {
        return super.exists(example);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public boolean existsByEntityProperty(String propertyName, String propertyValue) throws NoSuchFieldException {
        return super.existsByEntityProperty(propertyName, propertyValue);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public List<Teacher> advancedQuery(Teacher entity) {
        return super.advancedQuery(entity);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Page<Teacher> advancedQuery(Teacher entity, Pageable pageable) {
        return super.advancedQuery(entity, pageable);
    }

    @Override
    @Cacheable(value = "TEACHER_DETAILS", unless = "#result == null")
    public Set advanceSearchProperty(String property, String value) {
        return super.advanceSearchProperty(property, value);
    }
    // 以下这些方法都是不变更数据的查询方法，若为了提高并发性能，可以尽可能的加持缓存   ----结束

    // 以下是涉及到数据库变更的所有方法开始，这些方法不仅要维护自身的缓存，还要通知哪些依赖并观察自己的观察者去更新他们的缓存
    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public <S extends Teacher> Iterable<S> saveAll(Iterable<S> var1) {
        return super.saveAll(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public <S extends Teacher> S saveAndFlush(S var1) {
        return super.saveAndFlush(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public <S extends Teacher> S save(S var1) {
        return super.save(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void delete(Teacher var1) {
        super.delete(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void deleteById(Long var1) {
        super.deleteById(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void deleteAll(Iterable<? extends Teacher> var1) {
        super.deleteAll(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void deleteAllInBatch() {
        super.deleteAllInBatch();
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void deleteInBatch(Iterable<Teacher> var1) {
        super.deleteInBatch(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public int deleteAllById(Iterable<Long> var1) {
        return super.deleteAllById(var1);
    }

    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public <S extends Teacher> S update(S var1) {
        return super.update(var1);
    }

    // 以上是涉及到数据库变更的所有方法      --------结束

    // 以下这些方法是处理关联缓存一致性的 此处模拟：Teacher只观察Course一个组件，当Course变更时就可以更新Teacher对应的缓存 ----开始

    // 联动清除本地的缓存！
    @Override
    @CacheEvict(value = "TEACHER_DETAILS", allEntries = true)
    public void update(Observable o, Object arg) {
        log.info("联动清除Teacher缓存信息.....");
        log.info("Teacer组件收到的数据是：" + arg);
        log.info("如果不是全部清空Teacher的缓存数据，可以利用收到的数据进行精细化更新自己的缓存！");
    }

    // 以下这些方法是处理关联缓存一致性的 此处模拟：Teacher只观察Course一个组件，当Course变更时就可以更新Teacher对应的缓存 ----结束


}
