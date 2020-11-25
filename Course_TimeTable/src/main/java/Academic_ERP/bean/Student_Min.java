/*This module defines class Student_Min which includes attributes name of student and
* roll number of student. This module is created to be used by modules which will retrieve
* information like students enrolled for a subject etc.*/

package Academic_ERP.bean;

public class Student_Min {

    private String name;
    private String rollNo;

    public Student_Min(){
    }

    public Student_Min(String rollNo,String name){
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student_Min{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}
