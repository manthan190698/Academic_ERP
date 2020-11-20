package Academic_ERP.controllers;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Course_Min;
import Academic_ERP.bean.Student_Min;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {

    @Test
    void getIt() {
    }

    @Test
    void getStudentsEnrolled() {
    CourseController cc = new CourseController();
    List<Student_Min> sm = cc.getStudentsEnrolled("CS101");
    assertEquals(6,sm.size());
    }

    @Test
    void getCoursesInSlot() {
        CourseController cc = new CourseController();
        List<Course_Min> cm = cc.getCoursesInSlot("MTech CSE", 1);
        Course test = new Course("CS101", "Algorithms", "Muralidhara V N");
        List<Course> c1 = new ArrayList<>();
        c1.add(test);
        //System.out.println(cm.equals(c1));
        assertEquals(c1.size(), cm.size());
    }
}