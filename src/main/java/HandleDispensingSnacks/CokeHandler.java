package HandleDispensingSnacks;
import OperationsOfVendingMachine.*;

public class CokeHandler extends SnackDispenseHandler {

    public CokeHandler( SnackDispenseHandler next ) { super( next ); }

    @Override
    public void dispenseSnack(Snack snack) {

        if ( snack.getName().equals( "Coke" ) ) {
            snack.decreaseQuantity();
        } else {
            super.dispenseSnack( snack );
        }
    }
}
