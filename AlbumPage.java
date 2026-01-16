import javax.swing.*;
import java.awt.*;

public class AlbumPage extends JFrame {

    public AlbumPage() {
        setTitle("Albums");
        setSize(900, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(245, 220, 245));

        // ===== TITLE =====
        JLabel title = new JLabel("ALBUMS", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(new Color(145, 100, 200));
        title.setBounds(300, 20, 300, 50);
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

        // ===== ALBUMS =====
        addAlbum(panel, Main.class.getResource("image/bts-album-1.jpg"), "BE", 140, 100, 20.0);
        addAlbum(panel, Main.class.getResource("image/bts-album-2.jpg"), "Love Yourself: Answer", 370, 100, 25.0);
        addAlbum(panel, Main.class.getResource("image/bts-album-3.png"), "MAP OF THE SOUL: PERSONA", 600, 100, 30.0);

        add(panel);
        setVisible(true);
    }

    // ===== ALBUM COMPONENT =====
    private void addAlbum(
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

        ImageIcon icon = new ImageIcon(imageURL);
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBounds(x, y, 150, 150);
        panel.add(imgLabel);

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBounds(x - 25, y + 160, 200, 25);
        panel.add(nameLabel);

        JLabel priceLabel = new JLabel("RM " + price, SwingConstants.CENTER);
        priceLabel.setBounds(x - 25, y + 185, 200, 20);
        panel.add(priceLabel);

        JLabel qtyLabel = new JLabel("Qty:");
        qtyLabel.setBounds(x - 25, y + 210, 40, 25);
        panel.add(qtyLabel);

        JSpinner qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        qtySpinner.setBounds(x + 20, y + 210, 50, 25);
        panel.add(qtySpinner);

        JButton addBtn = new JButton("Add to Cart");
        addBtn.setBounds(x - 25, y + 245, 200, 25);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        panel.add(addBtn);

        addBtn.addActionListener(e -> {
            int quantity = (Integer) qtySpinner.getValue();
            Cart.addItem(name, price, quantity);
            JOptionPane.showMessageDialog(panel,
                    quantity + " x " + name + " added to cart");
        });
    }
}
