package vip.efactory.ejpa.example.service.impl;

import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.Course;
import vip.efactory.ejpa.example.repository.CourseRepository;
import vip.efactory.ejpa.example.service.ICourseService;

/**
 * @author dbdu
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepository> implements ICourseService {

}
