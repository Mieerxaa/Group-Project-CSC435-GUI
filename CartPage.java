import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartPage extends JFrame {

    public static String selectedPaymentMethod = ""; // static for global access

    public CartPage() {
        setTitle("Your Cart");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        // ===== TITLE =====
        JLabel title = new JLabel("Your Cart", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setBounds(300, 20, 300, 50);
        panel.add(title);

        // ===== BACK BUTTON =====
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(30, 30, 80, 30);
        backBtn.setFocusPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(backBtn);
        backBtn.addActionListener(e -> {new Main(); dispose();});

        // ===== CART LIST =====
        JTextArea orderList = new JTextArea();
        orderList.setEditable(false);
        orderList.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(orderList);
        scrollPane.setBounds(200, 100, 500, 220);
        panel.add(scrollPane);

        // ===== DISPLAY CART ITEMS =====
        double totalAmount = Cart.getTotal();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-30s%-10s%-10s\n", "Product", "Qty", "Price"));
        sb.append("------------------------------------------------------\n");

        if (Cart.cartItems.isEmpty()) {
            sb.append("Cart is empty.");
        } else {
            for (Cart.CartItem item : Cart.cartItems) {
                double itemTotal = item.price * item.quantity;
                sb.append(String.format("%-30s%-10dRM %.2f\n",
                        item.name, item.quantity, itemTotal));
            }
        }

        orderList.setText(sb.toString());

        // ===== TOTAL =====
        JLabel totalLabel = new JLabel("Total: RM " + String.format("%.2f", totalAmount));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalLabel.setBounds(350, 330, 300, 30);
        panel.add(totalLabel);

        // ===== PAYMENT METHOD LABEL =====
        JLabel paymentLabel = new JLabel("Choose Payment Method:", SwingConstants.CENTER);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 16));
        paymentLabel.setBounds(250, 360, 400, 25);
        panel.add(paymentLabel);

        // ===== PAYMENT METHOD BUTTONS =====
        JButton creditCardBtn = new JButton("Credit Card");
        JButton bankTransferBtn = new JButton("Bank Transfer");
        JButton eWalletBtn = new JButton("E-Wallet");

        creditCardBtn.setBounds(220, 390, 140, 40);
        bankTransferBtn.setBounds(370, 390, 140, 40);
        eWalletBtn.setBounds(520, 390, 140, 40);

        panel.add(creditCardBtn);
        panel.add(bankTransferBtn);
        panel.add(eWalletBtn);

        // BUTTON HIGHLIGHT LOGIC
        ArrayList<JButton> paymentButtons = new ArrayList<>();
        paymentButtons.add(creditCardBtn);
        paymentButtons.add(bankTransferBtn);
        paymentButtons.add(eWalletBtn);

        for (JButton btn : paymentButtons) {
            btn.addActionListener(e -> {
                selectedPaymentMethod = btn.getText();
                for (JButton b : paymentButtons) {
                    b.setBackground(null);
                    b.setForeground(Color.BLACK);
                }
                btn.setBackground(Color.BLUE);
                btn.setForeground(Color.WHITE);
            });
        }

        // ===== NEXT BUTTON =====
        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(380, 440, 140, 40);
        nextBtn.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(nextBtn);

        nextBtn.addActionListener(e -> {
            if (Cart.cartItems.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty!");
                return;
            }
            if (selectedPaymentMethod.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a payment method!");
                return;
            }
            new DetailsPage(Cart.getTotal(), selectedPaymentMethod); // pass total & payment method
            //dispose();
        });

        add(panel);
        setVisible(true);
    }
}
