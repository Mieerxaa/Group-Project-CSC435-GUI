import javax.swing.*;
import java.awt.*;

public class DetailsPage extends JFrame {

    public DetailsPage(double totalAmount, String paymentMethod) {
        setTitle("Your Details");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("YOUR DETAILS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setBounds(250, 50, 400, 50);
        panel.add(title);

        JLabel nameLabel = new JLabel("NAME :");
        JLabel addressLabel = new JLabel("ADDRESS :");
        JLabel phoneLabel = new JLabel("PHONE NUMBER :");

        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        addressLabel.setFont(new Font("Arial", Font.BOLD, 18));
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 18));

        nameLabel.setBounds(300, 150, 200, 30);
        addressLabel.setBounds(300, 200, 200, 30);
        phoneLabel.setBounds(300, 250, 200, 30);

        panel.add(nameLabel);
        panel.add(addressLabel);
        panel.add(phoneLabel);

        JTextField nameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField phoneField = new JTextField();

        nameField.setBounds(480, 150, 200, 30);
        addressField.setBounds(480, 200, 200, 30);
        phoneField.setBounds(480, 250, 200, 30);

        panel.add(nameField);
        panel.add(addressField);
        panel.add(phoneField);

        JLabel totalAmountLabel = new JLabel("TOTAL: RM " + String.format("%.2f", totalAmount), SwingConstants.CENTER);
        totalAmountLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalAmountLabel.setBounds(300, 300, 300, 30);
        panel.add(totalAmountLabel);

        JButton confirmBtn = new JButton("CONFIRM");
        confirmBtn.setBounds(380, 380, 140, 40);
        panel.add(confirmBtn);

        confirmBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String address = addressField.getText().trim();
            String phone = phoneField.getText().trim();

            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all details!");
                return;
            }


            // 1️⃣ SAVE TO FILE (cart still exists)
            ReceiptHelper.saveReceipt(
                    name,
                    address,
                    phone,
                    paymentMethod,
                    totalAmount
            );

            // 2️⃣ OPEN RECEIPT PAGE (cart still exists)


            new ThankYouPage(
                    name,
                    address,
                    phone,
                    paymentMethod,
                    totalAmount
            );

            // 3️⃣ CLEAR CART AFTER GUI RECEIPT
            CartPage.selectedPaymentMethod = "";
            dispose();
        });


        add(panel);
        setVisible(true);
    }
}
