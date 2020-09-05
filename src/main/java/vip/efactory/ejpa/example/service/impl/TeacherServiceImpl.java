package vip.efactory.ejpa.example.service.impl;

import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.Teacher;
import vip.efactory.ejpa.example.repository.TeacherRepository;
import vip.efactory.ejpa.example.service.ITeacherService;

/**
 * @author dbdu
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Long, TeacherRepository> implements ITeacherService {

}
