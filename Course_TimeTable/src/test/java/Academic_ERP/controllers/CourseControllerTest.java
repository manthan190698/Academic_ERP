/*Tests in this module are designed to test methods from CourseController.java
* 1. Method getStudentsEnrolled() retrieves information from the methods and checks whether
* received output is as expected or not. Since we are comparing output as string, relational and
* arithmetic mutants are killed.
* 2. Method getCourseInSlot() checks whether subjects received from the method for respective slot
* are correct.
* 3. Since we are comparing output as string, relational and arithmetic mutants are killed.
* 4. These test cases are verified with respect to designed */

package Academic_ERP.controllers;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Course_Min;
import Academic_ERP.bean.Student_Min;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {

    CourseController cc = new CourseController();
    @Test
    void getIt() {
    }

    @Test
    void getStudentsEnrolled() {
    List<Student_Min> sm = cc.getStudentsEnrolled("CS101");
    //System.out.println(sm);
    String compare = "[Student_Min{name='Manthan Fursule', rollNo=MT2019CS1}, Student_Min{name='Harshabh Mahanth', rollNo=MT2019CS3}, Student_Min{name='Sameer Khurd', rollNo=MT2019CS4}, Student_Min{name='Rohit Sharma', rollNo=MT2019CS5}, Student_Min{name='Vamsi Krishna', rollNo=MT2019CS9}, Student_Min{name='Tushar', rollNo=MT2019CS10}]";
    assertEquals(compare,sm.toString());

    }

    @Test
    void getCoursesInSlot() {
        List<Course_Min> cm = cc.getCoursesInSlot("MTech CSE", 1);
        Course test = new Course("CS101", "Algorithms", "Muralidhara V N");
        List<Course> c1 = new ArrayList<>();
        c1.add(test);
        System.out.println(cm);
        String compare = "[Course_Min{cid='CS101'name='Algorithms'faculty name='Muralidhara V N', slot No=1}]";
        assertEquals(compare,cm.toString());
        //System.out.println(cm);

    }

}