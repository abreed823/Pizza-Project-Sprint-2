public abstract class OrderItem {
    private String name;
    private int quantity;
    private double price;
    
    public String toString(){
        return name;
    }

    public OrderItem() {
        name = "boneless pizza";
        quantity = 1;
        price = 2.00;
    }
}
