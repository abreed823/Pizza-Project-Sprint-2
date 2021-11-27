import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The functionality and display for the Receipt page
 *
 * @author Team 2
 */
public class ReceiptPage {
    private JButton logOutButton;
    private JPanel receiptPanel;
    private JButton printButton;
    private JButton exitButton;
    private JTable receiptTable;
    private DefaultTableModel tableModel;

    /**
     * Constructor
     */
    public ReceiptPage() {
        createTable();
        exitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("welcome");
            }
        });
        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("print");
            }
        });
    }

    /**
     * Creates the JTable that shows the ordered items
     */
    private void createTable(){
        tableModel = new DefaultTableModel(
                null,
                new String[]{"Item Type", "Item Description", "Quantity", "Price"}
        );
        receiptTable.setModel(tableModel);
    }

    /**
     * Adds new items to the table
     * @param data the array of data to be added to the row
     */
    public void addTableRow(String[] data){
        tableModel.addRow(data);
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return receiptPanel;
    }
}
