package HandleDispensingSnacks;

import OperationsOfVendingMachine.Snack;

public class KitKatHandler extends SnackDispenseHandler {

    public KitKatHandler( SnackDispenseHandler next ) { super( next ); }

    public void dispenseSnack( Snack snack ) {
        if ( snack.getName().equals( "Kit Kat" ) ) {
            snack.decreaseQuantity();
        } else {
            super.dispenseSnack( snack );
        }
    }
}
