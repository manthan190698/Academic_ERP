/*This code is used to create database. It includes creation of mapping of professors with respective subjects
* and students with their enrollment into subjects of interests.
* Running this code will create sql database with tables Course, Domain, Domain_Course,
* Enrolled, Slot, Slot_Course and Student*/

package Academic_ERP;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Domain;
import Academic_ERP.bean.Slot;
import Academic_ERP.bean.Student;
import Academic_ERP.util.SessionUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateDatabase {

    public static void main(String args[]){
        utility();
    }

    public static int utility(){
        Domain MTechCSE = new Domain("MTech CSE");
        Domain MTechECE = new Domain("MTech ECE");
        Domain IMTechCSE = new Domain("IMTech CSE");

        List<Course> MtcsCourses = new ArrayList<>();
        List<Course> IMtcsCourses = new ArrayList<>();
        List<Course> MtecCourses = new ArrayList<>();

        String []MtcsCid = {"CS101","CS102","CS103","CS104","CS105","CS106","CS107"};
        String []IMtcsCid = {"CS501","CS502","CS503","CS504","CS505","CS506","CS507"};
        String []MtecCid = {"EC101","EC102","EC103","EC104","EC105","EC106","EC507"};

        String []MtcsCnames = {"Algorithms","Machine Learning","Networks","MML","Discreet Mathematics","System Software","DevOps"};
        String []IMtcsCnames = {"Data Structures","Operating Systems","Computer Organization","Computer Networks","Maths","Compiler Design","C++"};
        String []MtecCnames = {"VLSI","Networks","Analog Design","Control Systems","Digital Communication","Antenna Theory","Field theory"};

        String []MtcsFnames = {"Muralidhara V N","Neelam Sinha","Yashwanth","Ramasubhramaniam","Rajesh","R Chandrashekar","Thangraju"};
        String []IMtcsFnames = {"Muralidhara V N","Vikram Pai","Akshatha Shetty","Naveen Rai","Venkateshwara Bhat","Sidhaarth Mallya","Random guy"};
        String []MtecFnames = {"Varun Rao","Gopalakrishna Adiga","U B Mahadeva Swamy","Sudarshan Patil Kulkarni","Tom Cruise","Ramya Bhat","Rakesh"};

        //int noCoursesPerSem = 7;

        MtcsCourses = RegisterCourses(MtcsCid,MtcsCnames,MtcsFnames,MTechCSE,7);
        MtecCourses = RegisterCourses(MtcsCid,MtcsCnames,MtcsFnames,MTechECE,7);
        IMtcsCourses = RegisterCourses(MtcsCid,MtcsCnames,MtcsFnames,IMTechCSE,7);

        List<Student> MtcsStudents = new ArrayList<>();
        List<Student> MtecStudents = new ArrayList<>();
        List<Student> IMtcsStudents = new ArrayList<>();

        String[] MtcsSnames = {"Manthan Fursule","Vipin Rai P","Harshabh Mahanth","Sameer Khurd","Rohit Sharma","Saurabh Singh","Ayush Mishra","Ravi","Vamsi Krishna","Tushar"};
        String[] MtecSnames = {"Ponnana","Jayram Mendon","Aishwarya Shetty","Rakshith Gowda","Brijesh Rai","Ramkumar"};
        String[] IMtcsSnames = {"Rajath Singh","Rohith Shetty","Kanika Nayak","Supriya Acharya","Vivek Bhat","Raghavendra","Prashanth","Prathibha"};

        /* Enrolling Students */


        MtcsStudents = EnrollStudents(MtcsSnames,MtcsCourses,"MT2019CS",7);
        MtecStudents = EnrollStudents(MtecSnames,MtecCourses,"MT2019EC",7);
        IMtcsStudents = EnrollStudents(IMtcsSnames,IMtcsCourses,"IMT2019CS",7);

        /* Assign Slots */

        List<Slot> slots = new ArrayList<>();


        slots = createSlots(20);

        /* MTech cs time table */
        slots.get(0).addCourseToSlot(MtcsCourses.get(0));
        slots.get(1).addCourseToSlot(MtcsCourses.get(6));
        slots.get(4).addCourseToSlot(MtcsCourses.get(3));
        slots.get(4).addCourseToSlot(MtcsCourses.get(2)); //changed
        slots.get(6).addCourseToSlot(MtcsCourses.get(4));
        slots.get(8).addCourseToSlot(MtcsCourses.get(5));
        slots.get(10).addCourseToSlot(MtcsCourses.get(0));
        slots.get(12).addCourseToSlot(MtcsCourses.get(2));
        slots.get(13).addCourseToSlot(MtcsCourses.get(1));
        slots.get(15).addCourseToSlot(MtcsCourses.get(3));
        slots.get(16).addCourseToSlot(MtcsCourses.get(1));
        slots.get(18).addCourseToSlot(MtcsCourses.get(5));

        /* MTech ec time table */
        slots.get(0).addCourseToSlot(MtecCourses.get(2));
        slots.get(2).addCourseToSlot(MtecCourses.get(3));
        slots.get(3).addCourseToSlot(MtecCourses.get(0));
        slots.get(5).addCourseToSlot(MtecCourses.get(1));
        slots.get(7).addCourseToSlot(MtecCourses.get(5));
        slots.get(8).addCourseToSlot(MtecCourses.get(4));
        slots.get(11).addCourseToSlot(MtecCourses.get(2));
        slots.get(12).addCourseToSlot(MtecCourses.get(0));
        slots.get(14).addCourseToSlot(MtecCourses.get(3));
        slots.get(15).addCourseToSlot(MtecCourses.get(5));
        slots.get(16).addCourseToSlot(MtecCourses.get(4));
        slots.get(18).addCourseToSlot(MtecCourses.get(1));

        /* IMTech cs time table */
        slots.get(0).addCourseToSlot(IMtcsCourses.get(0));
        slots.get(2).addCourseToSlot(IMtcsCourses.get(4));
        slots.get(3).addCourseToSlot(IMtcsCourses.get(1));
        slots.get(4).addCourseToSlot(IMtcsCourses.get(5));
        slots.get(5).addCourseToSlot(IMtcsCourses.get(2));
        slots.get(7).addCourseToSlot(IMtcsCourses.get(3));
        slots.get(8).addCourseToSlot(IMtcsCourses.get(1));
        slots.get(9).addCourseToSlot(IMtcsCourses.get(2));
        slots.get(10).addCourseToSlot(IMtcsCourses.get(0));
        slots.get(12).addCourseToSlot(IMtcsCourses.get(4));
        slots.get(14).addCourseToSlot(IMtcsCourses.get(5));
        slots.get(17).addCourseToSlot(IMtcsCourses.get(3));


        /*
        Session session = SessionUtil.getSession();
        session.beginTransaction();


        for(Student student:MtcsStudents){
            session.save(student);
        }

        for(Student student:MtecStudents){
            session.save(student);
        }

        for(Student student:IMtcsStudents){
            session.save(student);
        }

        for(Course course:MtcsCourses){
            session.save(course);
        }

        for(Course course:MtecCourses){
            session.save(course);
        }

        for(Course course:IMtcsCourses){
            session.save(course);
        }

        session.save(MTechCSE);
        session.save(MTechECE);
        session.save(IMTechCSE);

        for (Slot slot:slots){
            session.save(slot);
        }

        session.getTransaction().commit();
        session.close();
        */


        return 0;
    }

    public static List<Slot> createSlots(int noSlots){
        List<Slot> slots = new ArrayList<>();
        int count = 0;
        for(int i=0;i<noSlots;i++){
            slots.add(new Slot(i+1));
            count++;
            if(count==noSlots)
                break;
        }
        return slots;
    }

    public static  List<Course> RegisterCourses(String courseIds[],String courseNames[],String facultyNames[],Domain domain,int noCoursesPerSem){
        List<Course> courses = new ArrayList<>();
        for(int i=0;i<noCoursesPerSem;i++){
            Course course = new Course(courseIds[i],courseNames[i],facultyNames[i]);

            courses.add(courses.size(),course);

            domain.addCourseToDomain(course);
        }

        return courses;
    }

    public static List<Student> EnrollStudents(String []studentNames,List<Course> courses,
                                               String prefix,int noCoursesPerSem){
        //int seed  = 10;
        Random random  = new Random(10);

        List<Student> students = new ArrayList<>();
        for(int i=0;i< studentNames.length;i++) {
            Student student = new Student(prefix + (i + 1), studentNames[i]);
            int taken = 0;
            while (taken < 4) {
                for (int courseNo = 0; courseNo < noCoursesPerSem; courseNo++) {
                    if ((random.nextInt(2) == 1) && taken < 4) {
                        student.enrollCourse(courses.get(courseNo));
                        courses.get(courseNo).enrollStudent(student);
                        taken += 1;
                    }
                }
            }
                students.add(student);

        }
        return students;
    }

}
