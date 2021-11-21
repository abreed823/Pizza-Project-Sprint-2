import javax.swing.*;

/**
 * Updates the total for the user's car
 */
public class CartTotal {
    private double cartTotal;
    private String totalPriceString;
    //private JLabel cartTotalLabel;

    /**
     * Constructor
     */
    CartTotal(){
        cartTotal = 0;
        totalPriceString = "Subtotal: $" + String.format("%.2f", cartTotal);
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
        totalPriceString = "Subtotal: $" + String.format("%.2f", cartTotal);
    }
}
