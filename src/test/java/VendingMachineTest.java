import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import VendingMachineState.*;
import HandleDispensingSnacks.*;

public class VendingMachineTest {

    @Test
    void vendingMachineStartsInIdleState() {
        VendingMachine vendingMachine = new VendingMachine();

        String expected = "IdleState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }


}
