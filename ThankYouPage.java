import javax.swing.*;
import java.awt.*;

public class ThankYouPage extends JFrame {

    public ThankYouPage(String name, String address, String phone, String paymentMethod, double totalAmount) {
        setTitle("Thank You");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(216, 190, 216));

        JLabel thankYouLabel = new JLabel("<html><center>THANK YOU<br>FOR<br>PURCHASING!</center></html>", SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 42));
        thankYouLabel.setBounds(200, 60, 500, 200);
        panel.add(thankYouLabel);

        JLabel receiptText = new JLabel("Print Your Receipt HERE", SwingConstants.CENTER);
        receiptText.setFont(new Font("Arial", Font.BOLD, 16));
        receiptText.setBounds(300, 260, 300, 30);
        panel.add(receiptText);

        JButton receiptBtn = new JButton("RECEIPT");
        receiptBtn.setBounds(350, 300, 200, 45);
        receiptBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        receiptBtn.setFocusPainted(false);
        panel.add(receiptBtn);

        receiptBtn.addActionListener(e -> {
            new ReceiptPage(name, address, phone, paymentMethod, totalAmount);
            Cart.clearCart();
        });


        JButton returnBtn = new JButton("Return");
        returnBtn.setBounds(780, 420, 90, 40);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 14));
        returnBtn.setFocusPainted(false);
        panel.add(returnBtn);

        returnBtn.addActionListener(e -> {
            new Main();
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}
