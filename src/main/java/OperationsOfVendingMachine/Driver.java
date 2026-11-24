package OperationsOfVendingMachine;
import HandleDispensingSnacks.*;
import VendingMachineState.*;
public class Driver {

    public static void main ( String [] args ){

        Snack coke = new Snack( "Coke" , 2.75 , 12 );
        Snack pepsi = new Snack( "Pepsi" , 2.25 , 15 );
        Snack cheetos = new Snack( "Cheetos" , 1.75 , 7 );
        Snack doritos = new Snack( "Doritos" , 1.75 , 9);
        Snack kitkat = new Snack( "KitKat" , 1.00 , 7 );
        Snack snickers = new Snack( "Snickers" , 1.00 , 2 );

        SnackDispenseHandler chain = new CokeHandler( new PepsiHandler( new CheetosHandler(
                new DoritosHandler( new KitKatHandler( new SnickersHandler( null ))))));


        System.out.println("\n Vending Machine State Process ");
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println( "Before Dispense Coke Quantity: " + coke.getQuantity() );
        System.out.println( "Initial State: " + vendingMachine.getState().getClass().getSimpleName() );
        vendingMachine.selectSnack("Coke");
        System.out.println( "After selecting snack: " + vendingMachine.getState().getClass().getSimpleName() );
        vendingMachine.insertMoney( 3 );
        System.out.println( "After inserting money: " + vendingMachine.getState().getClass().getSimpleName() );
        vendingMachine.dispenseSnack();
        chain.dispenseSnack( coke );
        System.out.println( "After Dispense Coke Quantity: " + coke.getQuantity() );
        System.out.println( "After dispensing snack: " + vendingMachine.getState().getClass().getSimpleName() );
        System.out.println( " Transaction Completed " );


        System.out.println("\n Insufficient Funds ");

        VendingMachine vendingMachine2 = new VendingMachine();

        vendingMachine2.selectSnack("Coke");
        vendingMachine2.insertMoney(2.75);

        System.out.println( "Money inserted: $2.75, Coke price: $3.00");
        System.out.println( "State After Insufficient Funds: " + vendingMachine2.getState().getClass().getSimpleName() );



        System.out.println( " \n Snickers Reached Zero Quantity " );
        System.out.println("Before Dispense Snickers Quantity: " + snickers.getQuantity() );
        chain.dispenseSnack( snickers );
        System.out.println("First Dispense Snickers Quantity: " + snickers.getQuantity() );
        chain.dispenseSnack( snickers );
        System.out.println( "Second Dispense Snickers Quantity: " + snickers.getQuantity() );

        System.out.println( "\n Snack out of stock " );
        chain.dispenseSnack( snickers );
        System.out.println( "Snickers Quantity: " + snickers.getQuantity() );

    }
}
