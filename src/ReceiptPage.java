import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * The functionality and display for the Receipt page
 *
 * @author Team 2
 */
public class ReceiptPage {
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
        receiptPanel.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component has been made visible.
             *
             * @param e
             */
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                int orderCount = initializeCount();
                File customerRecords = new File("src/CustomerRecords.txt");
                try {
                    FileWriter writer = new FileWriter(customerRecords,true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }


        });
    }
    private int initializeCount(){
        File count = new File("src/OrderCount.txt");
        Scanner sc = null;
        int temp = 0;
        try {
            sc = new Scanner(count);
            temp = sc.nextInt();
            sc.close();
            temp++;
            FileWriter countWriter = null;
            countWriter = new FileWriter(count, false);
            countWriter.write(""+temp);
            countWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       return temp;
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
