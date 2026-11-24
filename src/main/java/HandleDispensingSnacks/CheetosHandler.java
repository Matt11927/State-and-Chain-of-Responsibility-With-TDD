package HandleDispensingSnacks;

import OperationsOfVendingMachine.Snack;

public class CheetosHandler extends SnackDispenseHandler {

    public CheetosHandler( SnackDispenseHandler next ) { super( next ); }

    public void dispenseSnack( Snack snack ) {
        if ( snack.getName().equals( "Cheetos" ) ) {
            snack.decreaseQuantity();
        } else {
            super.dispenseSnack( snack );
        }
    }
}