package Academic_ERP.services;

import Academic_ERP.bean.Course;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class   CourseServicesImplTest {

    CourseServicesImpl csi = new CourseServicesImpl();
    @Test
    void findStudentsEnrolled() {
    }

    @Test
    void findCourseBySlotInDomain1() {

        Course test = new Course("CS101", "Algorithms", "Muralidhara V N");
        List<Course> c1 = new ArrayList<>();
        c1.add(test);
        List<Course> c2 = csi.findCourseBySlotInDomain(1, "MTech CSE");
        //System.out.println(c1.get(0).equals(c2.get(0)));
        assertEquals(c1.size(), c2.size());
    }
    @Test
    void findCourseBySlotInDomain2(){
        List<Course> c2 = csi.findCourseBySlotInDomain(3, "MTech CSE");
        assertEquals(0, c2.size());
    }
    @Test
    void findCourseBySlotInDomain3(){
        List<Course> c2 = csi.findCourseBySlotInDomain(5, "MTech CSE");
        assertEquals(2, c2.size());
    }


    @Test
    void findCourseBySlot() {
        List<Course> cis = csi.findCourseBySlot(3);

    }
}