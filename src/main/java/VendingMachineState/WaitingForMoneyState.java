package VendingMachineState;

import OperationsOfVendingMachine.VendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    @Override
    public void selectSnack( VendingMachine vendingMachine , String snackName ) {}
    @Override
    public void insertMoney( VendingMachine vendingMachine , double amount ) {
        if ( amount >= vendingMachine.getSnackPrice() ) {
            vendingMachine.setState( new DispensingState() );
        }
    }
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {}
}