import javax.swing.*;
import java.util.ArrayList;
/**
 * Updates the total for the user's car
 */
public class CartTotal {
    public static ArrayList<OrderItem> items = new ArrayList<OrderItem>();
    private double cartTotal;
    private String totalPriceString;
    //private JLabel cartTotalLabel;

    /**
     * Constructor
     */
    CartTotal(){
        cartTotal = 0;
        totalPriceString = "Cart Subtotal: $" + String.format("%.2f", cartTotal);
        //cartTotalLabel.setText("Subtotal: $" + totalPriceString);
    }

    /**
     * Returns the cart total label
     * @return the cart total label
     */
    public String getCartTotal(){
        return totalPriceString;
    }

    /**
     * Updates the price of the car
     * @param price the price to add to the cart
     */
    public void updateCartTotal(double price){
        cartTotal += price;
        totalPriceString = "Cart Subtotal: $" + String.format("%.2f", cartTotal);
    }
}
