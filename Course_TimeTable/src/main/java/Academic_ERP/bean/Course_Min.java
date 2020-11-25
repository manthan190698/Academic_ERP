/*This module defines class Course_Min which includes attributes course id, name of course,
 * faculty which will be teaching the respective subject and slot of the timetable in which
 * the subject will be taught. Methods include getter and setter methodsto assign values and
 * retrieve information from object of class Course_Min*/

package Academic_ERP.bean;

public class Course_Min {
    private String cid;
    private String name;
    private String facultyName;
    private  int slotNo;

    public Course_Min(){

    }

    public Course_Min(String cid, String name, String facultyName, int slotNo){
        this.cid = cid;
        this.name = name;
        this.facultyName = facultyName;
        this.slotNo = slotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Course_Min{" +
                "cid='" + cid + '\'' +
                "name='" + name + '\'' +
                "faculty name='" + facultyName + '\'' +
                ", slot No=" + slotNo +
                '}';
    }
}
