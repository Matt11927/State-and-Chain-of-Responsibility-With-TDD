package HandleDispensingSnacks;
import OperationsOfVendingMachine.*;

public class DoritosHandler extends SnackDispenseHandler {

    public DoritosHandler( SnackDispenseHandler next ) { super( next ); }

    public void dispenseSnack( Snack snack ) {
        if ( snack.getName().equals( "Doritos" ) ) {
            snack.decreaseQuantity();
        } else {
            super.dispenseSnack( snack );
        }
    }
}
