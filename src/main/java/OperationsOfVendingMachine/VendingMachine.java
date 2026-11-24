package OperationsOfVendingMachine;
import VendingMachineState.*;

public class VendingMachine {
    private StateOfVendingMachine state;

    public VendingMachine() { state = new IdleState(); }

    public void selectSnack( String snackName ) { state = new WaitingForMoneyState(); }

    public void insertMoney( double amount ) { state = new DispensingState(); }

    public void dispenseSnack() { state = new IdleState(); }

    public void dispenseSnack( Snack snack ) {
        snack.decreaseQuantity();
        state = new IdleState();
    }

    public StateOfVendingMachine getState() { return state; }
}
