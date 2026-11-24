package HandleDispensingSnacks;

import OperationsOfVendingMachine.Snack;

public class PepsiHandler extends SnackDispenseHandler {

    public PepsiHandler( SnackDispenseHandler next ) { super( next ); }

    public void dispenseSnack( Snack snack ) {
        if ( snack.getName().equals( "Pepsi" ) ) {
            snack.decreaseQuantity();
        } else {
            super.dispenseSnack( snack );
        }
    }
}