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
        Course test1 = new Course("EC104", "Control Systems", "Sudarshan Patil Kulkarni");
        Course test2 = new Course("CS505", "Maths", "Venkateshwara Bhat");
        List<Course> c1 = new ArrayList<>();
        c1.add(test1);
        c1.add(test2);
        List<Course> cis = csi.findCourseBySlot(3);
        //System.out.println(cis);
        assertTrue(arrayCompareCourses(c1,cis));


    }

    boolean arrayCompareCourses(List<Course> cmp1, List<Course> cmp2) {
        return cmp1.toString().contains(cmp2.toString());
    }

    boolean arrayCompareStudents(List<Student> std1, List<Student> std2){
        return std1.toString().contains(std2.toString());
    }
}