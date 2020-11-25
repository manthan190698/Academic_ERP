/*Tests defined in this module ensures that objects created of the type Course are being assigned
 * values as expected and returns a valid output for attributes Course id, name of the course and
 * name of the Professor.*/

package Academic_ERP.bean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course c = new Course("1","Algebra","Tom");
    @Test
    void getCid() {
        assertEquals(c.getCid(),"1");

    }

    @Test
    void getName() {
        assertEquals(c.getName(),"Algebra");
    }

    @Test
    void getStudentsEnrolled() {
        Student s1 = new Student("121","MMF");
        Course c = new Course();
        List<Student> st = new ArrayList<Student>();
        st.add(s1);
        c.enrollStudent(s1);
        assertEquals(st,c.getStudentsEnrolled());

    }

    @Test
    void getFacultyName() {
        Course c = new Course("1","Algebra","Tom");
        assertEquals(c.getFacultyName(),"Tom");
    }

}