import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    void vendingMachineStartsInIdleState() {
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue( vendingMachine.getState() instanceof IdleState );
    }


}
