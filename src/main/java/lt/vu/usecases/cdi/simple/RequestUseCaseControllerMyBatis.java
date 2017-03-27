package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.KlientasMapper;
import lt.vu.usecases.mybatis.model.Klientas;
import org.mybatis.cdi.Transactional;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {


    @Getter
    private Klientas klientas = new Klientas();

    @Inject
    private KlientasMapper klientasMapper;



    public List<lt.vu.usecases.mybatis.model.Klientas> getAllClients() {
        return klientasMapper.selectAll();
    }


    @Transactional
    public void createClient() {
        //courseMapper.insert(course);
        klientasMapper.insert(klientas);
//        StudentCourse studentCourse = new StudentCourse();
//        studentCourse.setCourseId(course.getId());
//        studentCourse.setStudentId(student.getId());
//        studentCourseMapper.insert(studentCourse);
        log.info("Maybe OK...");
    }





//    @Getter
//    private Course course = new Course();
//    @Getter
//    private Student student = new Student();
//
//    @Inject
//    private StudentMapper studentMapper;
//    @Inject
//    private CourseMapper courseMapper;
//    @Inject
//    private StudentCourseMapper studentCourseMapper;
//
//    public List<lt.vu.usecases.mybatis.model.Student> getAllStudents() {
//        return studentMapper.selectAll();
//    }
//
//    @Transactional
//    public void createCourseStudent() {
//        courseMapper.insert(course);
//        studentMapper.insert(student);
//        StudentCourse studentCourse = new StudentCourse();
//        studentCourse.setCourseId(course.getId());
//        studentCourse.setStudentId(student.getId());
//        studentCourseMapper.insert(studentCourse);
//        log.info("Maybe OK...");
//    }
}
