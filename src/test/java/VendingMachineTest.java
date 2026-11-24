import OperationsOfVendingMachine.Snack;
import OperationsOfVendingMachine.VendingMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        vendingMachine.insertMoney( 3 );

        String expected = "DispensingState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }

    @Test
    void dispenseSnackMovesToIdleState() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack( "Coke" );
        vendingMachine.insertMoney( 3 );
        vendingMachine.dispenseSnack();

        String expected = "IdleState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }

    @Test
    void dispensingSnackReducesQuantity() {
        Snack coke = new Snack( "Coke" , 2.75 , 5 );
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.dispenseSnack( coke );

        int expected = 4;
        int actual = coke.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void outOfStockSnackCannotBeDispensed() {
        Snack snickers = new Snack( "Snickers" ,  1.00 , 0 );
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.dispenseSnack( snickers );

        int expected = 0;
        int actual = snickers.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void cokeHandlerDispensesCoke() {
        Snack coke = new Snack( "Coke", 2.75 , 5 );
        SnackDispenseHandler chain = new CokeHandler( null );

        chain.dispenseSnack(coke);

        int expected = 4;
        int actual = coke.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void requestPassesToNextHandler() {
        Snack pepsi = new Snack( "Pepsi" , 2.75 , 5 );
        SnackDispenseHandler chain = new CokeHandler( new PepsiHandler( null ) );

        chain.dispenseSnack( pepsi );

        int expected = 4;
        int actual = pepsi.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void requestTravelsThroughEntireChain() {
        Snack snickers = new Snack( "Snickers", 1.00 , 5 );

        SnackDispenseHandler chain = new CokeHandler( new PepsiHandler( new CheetosHandler(
        new DoritosHandler( new KitKatHandler( new SnickersHandler( null ))))));

        chain.dispenseSnack( snickers );

        int expected = 4;
        int actual = snickers.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void snickersQuantityReachesZero() {
        Snack snickers = new Snack( "Snickers" , 1.00 , 2 );

        SnackDispenseHandler chain = new SnickersHandler( null );

        chain.dispenseSnack( snickers );
        chain.dispenseSnack( snickers );

        int expected = 0;
        int actual = snickers.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void snickersCannotGoBelowZero() {
        Snack snickers = new Snack( "Snickers" , 1.00 , 0 );
        SnackDispenseHandler chain = new SnickersHandler( null );

        chain.dispenseSnack( snickers );

        int expected = 0;
        int actual = snickers.getQuantity();

        assertEquals( expected , actual );
    }

    @Test
    void insufficientFundsStayInWaitingForMoneyState() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack( "Coke" );
        vendingMachine.insertMoney( 2.75 );

        String expected = "WaitingForMoneyState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }

    @Test
    void sufficientFundsMoveToDispensingState() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack( "Coke" );
        vendingMachine.insertMoney( 3.00 );

        String expected = "DispensingState";
        String actual = vendingMachine.getState().getClass().getSimpleName();

        assertEquals( expected , actual );
    }



}
