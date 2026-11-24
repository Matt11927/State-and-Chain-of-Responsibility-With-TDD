import VendingMachineState.*;

public class VendingMachine {
    private StateOfVendingMachine state;
    public VendingMachine() { state = new IdleState(); }
    public void selectSnack(String snackName) { state = new WaitingForMoneyState(); }
    public StateOfVendingMachine getState() { return state; }
}
