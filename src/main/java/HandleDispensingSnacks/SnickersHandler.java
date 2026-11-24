package HandleDispensingSnacks;

import OperationsOfVendingMachine.Snack;

public class SnickersHandler extends SnackDispenseHandler {

    public SnickersHandler( SnackDispenseHandler next ) { super( next ); }

    public void dispenseSnack( Snack snack ) {
        if ( snack.getName().equals( "Snickers" ) ) {
            snack.decreaseQuantity();
        } else {
            super.dispenseSnack( snack );
        }
    }
}
