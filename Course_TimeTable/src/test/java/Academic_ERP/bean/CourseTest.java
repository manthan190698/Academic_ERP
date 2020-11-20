package Academic_ERP.bean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    void getCid() {
        Course c = new Course("1","Algebra","Tom");
        assertEquals(c.getCid(),"1");
    }

    @Test
    void getName() {
        Course c = new Course("1","Algebra","Tom");
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