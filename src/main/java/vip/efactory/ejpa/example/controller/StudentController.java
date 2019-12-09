package vip.efactory.ejpa.example.controller;

import org.springframework.stereotype.Controller;
import vip.efactory.ejpa.base.controller.BaseController;
import vip.efactory.ejpa.example.entity.Student;
import vip.efactory.ejpa.example.service.IStudentService;

@Controller
public class StudentController extends BaseController<Student, IStudentService> {

}
