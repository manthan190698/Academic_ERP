package Academic_ERP.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlotTest {

    @Test
    void getSlotNo() {
        Slot slt = new Slot(5);
        assertEquals(slt.getSlotNo(), 5);
    }

    @Test
    void setSlotNo() {
        Slot slt = new Slot();
        slt.setSlotNo(10);
    }

    @Test
    void testToString() {
        Slot slt = new Slot(7);
        assertEquals(slt.getSlotNo(), 7);
    }
}