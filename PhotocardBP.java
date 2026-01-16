import javax.swing.*;
import java.awt.*;

public class PhotocardBP extends JFrame {

    public PhotocardBP() {
        setTitle("Photocards");
        setSize(900, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 170, 185));

        // ===== TITLE =====
        JLabel title = new JLabel("PHOTOCARDS", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
        title.setForeground(Color.BLACK);
        title.setBounds(250, 20, 400, 60);
        panel.add(title);

        // ===== BACK BUTTON =====
        JButton backBtn = new JButton("back");
        backBtn.setBounds(30, 30, 80, 30);
        backBtn.setFocusPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(backBtn);
        backBtn.addActionListener(e -> {
            new CategoryPageBP();
            dispose();
        });

        // ===== CART BUTTON =====
        JButton cartBtn = new JButton("cart");
        cartBtn.setBounds(760, 400, 80, 30);
        cartBtn.setFocusPainted(false);
        cartBtn.setContentAreaFilled(false);
        cartBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(cartBtn);
        cartBtn.addActionListener(e -> {new CartPage(); dispose();});

        // ===== ITEMS =====
        addItem(panel, "RM Photocard", 140, 140, 10.0, "image/bp-pc-1.jpg");
        addItem(panel, "JIN Photocard", 370, 140, 12.0, "image/bp-pc-2.jpg");
        addItem(panel, "JUNGKOOK Photocard", 600, 140, 15.0, "image/bp-pc-3.png");

        add(panel);
        setVisible(true);
    }

    private void addItem(JPanel panel, String name, int x, int y, double price, String imagePath) {

        // LOAD IMAGE USING getResource()
        ImageIcon icon = new ImageIcon(
                PhotocardPage.class.getResource(imagePath)
        );

        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(x, y, 150, 150);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imageLabel);

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBounds(x - 25, y + 160, 200, 25);
        panel.add(nameLabel);

        JLabel priceLabel = new JLabel("RM " + String.format("%.2f", price), SwingConstants.CENTER);
        priceLabel.setBounds(x - 25, y + 185, 200, 20);
        panel.add(priceLabel);

        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setBounds(x - 25, y + 210, 60, 25);
        panel.add(qtyLabel);

        JSpinner qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        qtySpinner.setBounds(x + 35, y + 210, 50, 25);
        panel.add(qtySpinner);

        JButton addBtn = new JButton("Add to Cart");
        addBtn.setBounds(x - 25, y + 245, 200, 25);
        addBtn.setBackground(new Color(145, 100, 200));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);
        panel.add(addBtn);

        addBtn.addActionListener(e -> {
            int quantity = (Integer) qtySpinner.getValue();
            Cart.addItem(name, price, quantity);
            JOptionPane.showMessageDialog(panel, quantity + " x " + name + " added to cart");
        });
    }

}
