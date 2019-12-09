package vip.efactory.ejpa.example.service.impl;

import org.springframework.stereotype.Service;
import vip.efactory.ejpa.base.service.impl.BaseServiceImpl;
import vip.efactory.ejpa.example.entity.Student;
import vip.efactory.ejpa.example.repository.StudentRepository;
import vip.efactory.ejpa.example.service.IStudentService;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, Long, StudentRepository> implements IStudentService {
}
