
public class Pizza extends OrderItem{
    private String name;
    private int quantity;
    private double price;
    private String[] toppings;
    private String size;
    private String crust;

    public Pizza(int quantity, double price, String[] toppings, String size, String crust) {
        this.quantity = quantity;
        this.price = price;
        this.toppings = toppings;
        this.size = size;
        this.crust = crust;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }
    /**
     *Default constructor
     *
     */
    public Pizza(){
        name = "pizza";
        quantity = 1;
        price = 3.99;
        toppings = new String[]{};
        size = "Medium";
        crust = "Hand tossed";
        }
      public String toString(){
        if(toppings.length < 1){
            return size + " " + crust + " pizza";
        }
        else if(toppings.length == 1){
            return size + " " + crust + " pizza with " + toppings[0];
        }
        else if(toppings.length == 2){
            return size + " " + crust + " pizza with " + toppings[0] + " and " + toppings[1];
        }
        else{
            String toppingsToString = "";
            for(int i = 0; i <toppings.length-1;i++){
                toppingsToString += toppings[i] + ", ";
                }
            toppingsToString += "and " + toppings[toppings.length-1];
        return size + " " + crust + " pizza with " + toppingsToString;
        }
    }
}
