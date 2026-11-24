package OperationsOfVendingMachine;

import VendingMachineState.*;

public class VendingMachine {
    private StateOfVendingMachine state;
    private double snackPrice;

    public VendingMachine() { state = new IdleState(); }

    public void selectSnack( String snackName ) {
        state.selectSnack( this , snackName );
    }

    public void insertMoney( double amount ) {
        state.insertMoney( this , amount );
    }

    public void dispenseSnack() {
        state.dispenseSnack( this );
    }

    public void dispenseSnack( Snack snack ) {
        snack.decreaseQuantity();
        state = new IdleState();
    }

    public StateOfVendingMachine getState() { return state; }

    public void setState(StateOfVendingMachine state) { this.state = state; }

    public double getSnackPrice() { return snackPrice; }

    public void setSnackPrice(double snackPrice) { this.snackPrice = snackPrice; }
}