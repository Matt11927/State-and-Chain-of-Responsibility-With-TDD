import VendingMachineState.*;

public class VendingMachine {
    private StateOfVendingMachine state;

    public VendingMachine() { state = new IdleState(); }

    public StateOfVendingMachine getState() { return state; }
}