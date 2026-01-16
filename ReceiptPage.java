import javax.swing.*;
import java.awt.*;

public class ReceiptPage extends JFrame {

    public ReceiptPage(String name, String address, String phone, String paymentMethod, double totalAmount) {
        setTitle("Receipt");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("RECEIPT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(250, 20, 300, 40);
        panel.add(title);

        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        StringBuilder receiptText = new StringBuilder();
        receiptText.append("KPOP ONLINE MERCHANDISE\n");
        receiptText.append("------------------------------------------\n");
        receiptText.append("Customer Name   : ").append(name).append("\n");
        receiptText.append("Address         : ").append(address).append("\n");
        receiptText.append("Phone Number    : ").append(phone).append("\n");
        receiptText.append("Payment Method  : ").append(paymentMethod).append("\n");
        receiptText.append("------------------------------------------\n\n");

        receiptText.append(String.format("%-20s %-5s %-10s\n", "Product", "Qty", "Subtotal"));
        receiptText.append("------------------------------------------\n");

        for (Cart.CartItem item : Cart.cartItems) {
            double subtotal = item.price * item.quantity;
            receiptText.append(String.format("%-20s %-5d RM%-8.2f\n", item.name, item.quantity, subtotal));
        }

        receiptText.append("\nTOTAL: RM ").append(String.format("%.2f", totalAmount));
        receiptArea.setText(receiptText.toString());

        JScrollPane scroll = new JScrollPane(receiptArea);
        scroll.setBounds(40, 80, 700, 330);
        panel.add(scroll);

        add(panel);
        setVisible(true);
    }
}
