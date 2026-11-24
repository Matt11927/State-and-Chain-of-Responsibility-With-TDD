package OperationsOfVendingMachine;

public class Snack {

    private String name;
    private double price;
    private int quantity;

    public Snack( String name , double price , int quantity ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() { return quantity; }

    public void decreaseQuantity() {
       if( quantity > 0 )
        quantity--;
    }

    public Object getName() { return name; }
}
