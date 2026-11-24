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

    @Test
    void selectSnackMovesToWaitingForMoneyState() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack( "Coke" );

        String expected = "WaitingForMoneyState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }

    @Test
    void insertMoneyMovesToDispensingState() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack( "Coke" );
        vendingMachine.insertMoney( 2.75 );

        String expected = "DispensingState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }

    @Test
    void dispenseSnackMovesToIdleState() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack( "Coke" );
        vendingMachine.insertMoney( 2.75 );
        vendingMachine.dispenseSnack();

        String expected = "IdleState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }


}
