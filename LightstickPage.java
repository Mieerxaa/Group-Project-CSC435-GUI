import javax.swing.*;
import java.awt.*;

public class LightstickPage extends JFrame {

    public LightstickPage() {
        setTitle("Lightsticks");
        setSize(900, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(245, 220, 245));

        // ===== TITLE =====
        JLabel title = new JLabel("LIGHTSTICKS", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(new Color(145, 100, 200));
        title.setBounds(250, 20, 400, 50);
        panel.add(title);

        // ===== BACK BUTTON =====
        JButton backBtn = new JButton("back");
        backBtn.setBounds(30, 30, 80, 30);
        backBtn.setFocusPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(backBtn);

        backBtn.addActionListener(e -> {
            new CategoryPage();
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

        // ===== LIGHTSTICK ITEMS =====
        addItem(
                panel,
                LightstickPage.class.getResource("image/bts-ls-1.jpg"),
                "ARMY BOMB MAP OF THE SOUL\nSpecial Edition",
                200, 140,
                129.90
        );

        addItem(
                panel,
                LightstickPage.class.getResource("image/bts-ls-2.jpg"),
                "ARMY BOMB",
                500, 140,
                99.90
        );

        add(panel);
        setVisible(true);
    }

    // ===== ITEM COMPONENT =====
    private void addItem(
            JPanel panel,
            java.net.URL imageURL,
            String name,
            int x, int y,
            double price) {

        if (imageURL == null) {
            JOptionPane.showMessageDialog(panel,
                    "Image not found for " + name);
            return;
        }

        // Image
        ImageIcon icon = new ImageIcon(imageURL);
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(x, y, 150, 150);
        panel.add(imageLabel);

        // Name (supports 2 lines)
        JLabel nameLabel = new JLabel(
                "<html><center>" + name.replace("\n", "<br>") + "</center></html>",
                SwingConstants.CENTER
        );
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBounds(x - 25, y + 160, 200, 40);
        panel.add(nameLabel);

        // Price
        JLabel priceLabel = new JLabel(
                "RM " + String.format("%.2f", price),
                SwingConstants.CENTER
        );
        priceLabel.setBounds(x - 25, y + 200, 200, 20);
        panel.add(priceLabel);

        // Quantity
        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setBounds(x - 25, y + 225, 60, 25);
        panel.add(qtyLabel);

        JSpinner qtySpinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 100, 1)
        );
        qtySpinner.setBounds(x + 35, y + 225, 50, 25);
        panel.add(qtySpinner);

        // Add to Cart
        JButton addBtn = new JButton("ADD TO CART");
        addBtn.setBounds(x - 25, y + 260, 200, 30);
        addBtn.setFocusPainted(false);
        addBtn.setBackground(new Color(145, 100, 200));
        addBtn.setForeground(Color.WHITE);
        panel.add(addBtn);

        addBtn.addActionListener(e -> {
            int quantity = (Integer) qtySpinner.getValue();
            Cart.addItem(name.replace("\n", " "), price, quantity);
            JOptionPane.showMessageDialog(panel,
                    quantity + " x " + name.replace("\n", " ") + " added to cart");
        });
    }
}
