package Academic_ERP;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Domain;
import Academic_ERP.bean.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CreateDatabaseTest {

    @Test
    void main() {
        
    }

    @Test
    void registerCourses() {
        String []courseIds = {"CS102","CS103","CS104"};
        String []courseNames = {"Computer Networks","Design Patterns","Software Testing"};
        String []facultyNames = {"Prof Thangaraju","Prof R Chandrashekaran","Prof Meenakshi D'souza"};
        Domain domain = new Domain("Computer Science");

        CreateDatabase.RegisterCourses(courseIds,courseNames,facultyNames,domain,3);
        assertEquals(3,domain.getCoursesOffered().size());
    }

    @Test
    void EnrollStudents() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS102","Computer Networks","Prof Thangaraju"));
        courses.add(new Course("CS103","Design Patterns","Prof R Chandrashekaran"));
        courses.add(new Course("CS104","Software Testing","Prof Meenakshi D'souza"));
        courses.add(new Course("CS105","Software Architecture","Prof R Chandrashekaran"));
        courses.add(new Course("CS106","Software Production Engineering","Prof Thangaraju"));
        courses.add(new Course("CS107","Enterprise Software","Prof Muralidhara V N"));

        String []studentNames = {"Vipin Rai","Manthan Fursule","Harshabh Mahant","Sameer Khurd"};
        int seed = 11;
        Random random  = new Random(11);
        int noOfCoursesPerSem = 3;
        List<Student> students = CreateDatabase.EnrollStudents(studentNames,courses,random,"MT2019CS",noOfCoursesPerSem);
        assertEquals(studentNames.length,students.size());
    }


    @Test
    void isEnrollingValid() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS102","Computer Networks","Prof Thangaraju"));
        courses.add(new Course("CS103","Design Patterns","Prof R Chandrashekaran"));
        courses.add(new Course("CS104","Software Testing","Prof Meenakshi D'souza"));
        courses.add(new Course("CS105","Software Architecture","Prof R Chandrashekaran"));
        courses.add(new Course("CS106","Software Production Engineering","Prof Thangaraju"));
        courses.add(new Course("CS107","Enterprise Software","Prof Muralidhara V N"));

        String []studentNames = {"Vipin Rai","Manthan Fursule","Harshabh Mahant","Sameer Khurd"};
        int seed = 11;
        Random random  = new Random(11);
        int noOfCoursesPerSem = 3;
        List<Student> students = CreateDatabase.EnrollStudents(studentNames,courses,random,"MT2019CS",noOfCoursesPerSem);
        assertEquals(4,students.get(new Random().nextInt(studentNames.length)).getCoursesEnrolled().size());
    }

}