/*Tests defined in this module ensures that objects created of the slot are being assigned
 * values as expected and returns a valid output for attribute slot number. It also ensures the
 * java method toString() is being overridden properly*/

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
        assertEquals(slt.getSlotNo(), 10);

    }

    @Test
    void testToString() {
        Slot slt = new Slot(3);
        slt.setId((long) 22);
        //System.out.println(slt.toString());
        String test = "Slot{id=22, slotNo=3}";
        assertEquals(slt.toString(), test);
    }


}