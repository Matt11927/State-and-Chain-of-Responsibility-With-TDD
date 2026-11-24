package VendingMachineState;
import OperationsOfVendingMachine.VendingMachine;

public class DispensingState implements StateOfVendingMachine {
    @Override
    public void selectSnack( VendingMachine vendingMachine , String snackName ) {}
    @Override
    public void insertMoney( VendingMachine vendingMachine , double amount ) {}
    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        vendingMachine.setState( new IdleState() );
    }
}