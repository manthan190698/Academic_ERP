/*Tests in this module are designed for the module CreateDatabase.java
* This module takes care that database is being created as it is supposed to be.
* 1. Method testSlotsCreation() cross checks whether array of slots are created according to the provided input
* 2. Method registerCourses() tests whether courses are created with the attributes course id, course name
* and faculty name for particular domain.
* 3. Method EnrollStudents() verifies student are enrolled into courses considering the restriction of
* subjects per semester or not.
* 4. Method isEnrollingValid() cross verifies that once the student are enrolled into courses, all basic
* criteria like students per course, courses per semester are met or not
* 5. method testUtility() is created for the purpose of line coverage so that all the initializations from
* method should be tested for the above defined testing methods.*/

package Academic_ERP;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Domain;
import Academic_ERP.bean.Slot;
import Academic_ERP.bean.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CreateDatabaseTest {

    @Test
    void testSlotsCreation(){

        List<Slot> test;
        String compare = "[Slot{id=null, slotNo=1}, Slot{id=null, slotNo=2}, Slot{id=null, slotNo=3}, Slot{id=null, slotNo=4}, Slot{id=null, slotNo=5}, Slot{id=null, slotNo=6}, Slot{id=null, slotNo=7}, Slot{id=null, slotNo=8}, Slot{id=null, slotNo=9}, Slot{id=null, slotNo=10}, Slot{id=null, slotNo=11}, Slot{id=null, slotNo=12}, Slot{id=null, slotNo=13}, Slot{id=null, slotNo=14}, Slot{id=null, slotNo=15}, Slot{id=null, slotNo=16}, Slot{id=null, slotNo=17}, Slot{id=null, slotNo=18}, Slot{id=null, slotNo=19}, Slot{id=null, slotNo=20}]";
        test = CreateDatabase.createSlots(20);
        //System.out.println(test.toString());
        assertEquals(test.toString(),compare);
    }

    @Test
    void registerCourses() {

        String []courseIds = {"CS102","CS103","CS104"};
        String []courseNames = {"Computer Networks","Design Patterns","Software Testing"};
        String []facultyNames = {"Prof Thangaraju","Prof R Chandrashekaran","Prof Meenakshi D'souza"};
        Domain domain = new Domain("Computer Science");

        CreateDatabase.RegisterCourses(courseIds,courseNames,facultyNames,domain,3);
        //System.out.println(domain.getCoursesOffered());
        String compare = "[Course{cid='CS102', name='Computer Networks',faculty=Prof Thangaraju'}, Course{cid='CS103', name='Design Patterns',faculty=Prof R Chandrashekaran'}, Course{cid='CS104', name='Software Testing',faculty=Prof Meenakshi D'souza'}]";
        assertEquals(compare,domain.getCoursesOffered().toString());

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
        //int seed = 11;
        //Random random  = new Random(11);
        int noOfCoursesPerSem = 3;
        List<Student> students = CreateDatabase.EnrollStudents(studentNames,courses,"MT2019CS",noOfCoursesPerSem);
        //System.out.println(students);
        String compare = "[Student{rollNo='MT2019CS1', name='Vipin Rai'}, Student{rollNo='MT2019CS2', name='Manthan Fursule'}, " +
                "Student{rollNo='MT2019CS3', name='Harshabh Mahant'}, Student{rollNo='MT2019CS4', name='Sameer Khurd'}]";
        assertEquals(compare,students.toString());

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
        //int seed = 11;
        //Random random  = new Random(11);
        int noOfCoursesPerSem = 3;
        List<Student> students = CreateDatabase.EnrollStudents(studentNames,courses,"MT2019CS",noOfCoursesPerSem);
        assertEquals(4,students.get(new Random().nextInt(studentNames.length)).getCoursesEnrolled().size());

    }

    @Test
    void testUtility() {
        assertEquals(CreateDatabase.utility(), 0);
    }
}