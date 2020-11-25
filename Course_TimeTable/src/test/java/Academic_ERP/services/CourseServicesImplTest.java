/*Tests in this module are generated to test module CourseServicesImpl.java
* 1. Method findStudentsEnrolled() checks whether the method works in the supposed way for the
* custom inputs. It checks whether array returned by the method are the students enrolled for the
* needed subject.
* 2. Method findCourseBySlotInDomain() checks for the output of courses in particular slot for the
* particular domain.
* 3. Method findCourseBySlot() checks array returned by the method contain list of all the courses being
* taught in particular slot.
* 4. As content of arraylist of type a class cannot be compared directly, custom functions are
* created to check the arraylists and the output is verified using assert statements.*/

package Academic_ERP.services;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Student;
import Academic_ERP.bean.Student_Min;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class   CourseServicesImplTest {

    CourseServicesImpl csi = new CourseServicesImpl();

    @Test
    void findStudentsEnrolled() {
        List<Student> stu = csi.findStudentsEnrolled("CS503");
        Student s1 = new Student("IMT2019CS2","Rohith Shetty");
        Student s2 = new Student("IMT2019CS5","Vivek Bhat");
        Student s3 = new Student("IMT2019CS8","Prathibha");
        List<Student> st = new ArrayList<>();
        st.add(s1);
        st.add(s2);
        st.add(s3);
        assertTrue(arrayCompareStudents(stu,st));
    }

    @Test
    void findCourseBySlotInDomain() {
        Course test = new Course("CS101", "Algorithms", "Muralidhara V N");
        List<Course> c1 = new ArrayList<>();
        c1.add(test);
        List<Course> c2 = csi.findCourseBySlotInDomain(1, "MTech CSE");
        assertTrue(arrayCompareCourses(c1,c2));
    }

    @Test
    void findCourseBySlot() {
        Course test1 = new Course("CS101", "Algorithms", "Muralidhara V N");
        Course test2 = new Course("EC103", "Analog Design", "U B Mahadeva Swamy");
        Course test3 = new Course("CS501", "Data Structures", "Muralidhara V N");
        List<Course> c1 = new ArrayList<>();
        c1.add(test1);
        c1.add(test2);
        c1.add(test3);
        List<Course> cis = csi.findCourseBySlot(1);
        //System.out.println(csi.findCourseBySlot(1));
        assertTrue(arrayCompareCourses(c1,cis));
    }

    boolean arrayCompareCourses(List<Course> cmp1, List<Course> cmp2) {
        return cmp1.toString().contains(cmp2.toString());
    }

    boolean arrayCompareStudents(List<Student> std1, List<Student> std2){
        return std1.toString().contains(std2.toString());
    }
}