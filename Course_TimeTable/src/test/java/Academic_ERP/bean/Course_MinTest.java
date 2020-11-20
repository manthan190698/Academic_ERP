package Academic_ERP.bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Course_MinTest {

    @Test
    void getSlotNo() {
        Course_Min cm = new Course_Min("1","Manthan","Vipin",2);
        int slot = cm.getSlotNo();
        assertEquals(slot,2);
    }

    @Test
    void setSlotNo() {
        Course_Min cm = new Course_Min();
        cm.setSlotNo(22);
        assertEquals(cm.getSlotNo(),22);
    }
}