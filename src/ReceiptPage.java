import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
    private JLabel cartSubtotalLabel;
    private JLabel taxLabel;
    private JLabel finalTotalLabel;
    private DefaultTableModel tableModel;

    private double tax;

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
        receiptPanel.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component has been made visible.
             *
             * @param e
             */
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                tax = Main.getCartTotalDouble() * 0.04;
                cartSubtotalLabel.setText(Main.getCartTotalString());
                taxLabel.setText("Tax: $" + String.format("%.2f", tax));
                finalTotalLabel.setText("Total: $" + String.format("%.2f", Main.getCartTotalDouble() + tax));
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

        TableColumnModel columnModel = receiptTable.getColumnModel();
        columnModel.getColumn(0).setMinWidth(100);
        columnModel.getColumn(0).setMaxWidth(100);
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setMinWidth(750);
        columnModel.getColumn(1).setMaxWidth(750);
        columnModel.getColumn(1).setPreferredWidth(750);
        columnModel.getColumn(2).setMinWidth(100);
        columnModel.getColumn(2).setMaxWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setMinWidth(100);
        columnModel.getColumn(3).setMaxWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
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
