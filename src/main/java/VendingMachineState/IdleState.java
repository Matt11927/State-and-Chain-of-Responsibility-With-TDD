package VendingMachineState;

import OperationsOfVendingMachine.VendingMachine;

public class IdleState implements StateOfVendingMachine {

    @Override
    public void selectSnack( VendingMachine vendingMachine , String snackName ) {
        vendingMachine.setSnackPrice( 3.00 );
        vendingMachine.setState( new WaitingForMoneyState() );
    }
    @Override
    public void insertMoney( VendingMachine vendingMachine , double amount ) {}
    @Override
    public void dispenseSnack( VendingMachine vendingMachine ) {}
}