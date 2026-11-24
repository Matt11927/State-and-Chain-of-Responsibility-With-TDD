package OperationsOfVendingMachine;
import VendingMachineState.*;

public class VendingMachine {

    private StateOfVendingMachine state;
    private double snackPrice;

    public VendingMachine() { state = new IdleState(); }

    public void selectSnack(String snackName) {
        snackPrice = 3;
        state = new WaitingForMoneyState();
    }

    public void insertMoney(double amount) {
        if (amount >= snackPrice) {
            state = new DispensingState();
        }
    }

    public void dispenseSnack() {
        state = new IdleState();
    }

    public void dispenseSnack(Snack snack) {
        snack.decreaseQuantity();
        state = new IdleState();
    }
    public StateOfVendingMachine getState() { return state; }

}
