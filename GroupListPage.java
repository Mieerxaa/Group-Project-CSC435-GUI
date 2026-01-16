import javax.swing.*;
import java.awt.*;

public class GroupListPage extends JFrame {

    public GroupListPage() {
        setTitle("Group List");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== TOP BAR =====
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JButton backBtn = new JButton("back");
        JButton cartBtn = new JButton("cart");

        backBtn.setFocusPainted(false);
        cartBtn.setFocusPainted(false);

        JLabel title = new JLabel("Group list", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));

        topPanel.add(backBtn, BorderLayout.WEST);
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(cartBtn, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // ===== CENTER CARDS =====
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 40, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 40, 40));

        centerPanel.add(createGroupCard(
                Main.class.getResource("image/BTS-LOGO.jpg"), "BTS",
                e -> { new CategoryPage(); dispose(); }
        ));

        centerPanel.add(createGroupCard(
                Main.class.getResource("image/BP-LOGO.jpg"), "BLACKPINK",
                e -> { new CategoryPageBP(); dispose(); }
        ));

        centerPanel.add(createGroupCard(
                Main.class.getResource("image/NEWJEANS-LOGO.jpg"), "NEWJEANS",
                e -> { new CategoryPageNJ(); dispose(); }
        ));

        add(centerPanel, BorderLayout.CENTER);

        // ===== ACTIONS =====
        backBtn.addActionListener(e -> {
            new Main();
            dispose();
        });

        cartBtn.addActionListener(e -> {
            new CartPage();
            dispose();
        });

        setVisible(true);
    }

    // ===== GROUP CARD METHOD =====
    private JPanel createGroupCard(
            java.net.URL imageURL,
            String name,
            java.awt.event.ActionListener action) {

        JPanel card = new JPanel(new BorderLayout(0, 10));

        // Image
        ImageIcon icon = new ImageIcon(imageURL);
        Image img = icon.getImage().getScaledInstance(220, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Button
        JButton btn = new JButton(name);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(173, 195, 215));
        btn.setOpaque(true);

        btn.addActionListener(action);

        card.add(imageLabel, BorderLayout.CENTER);
        card.add(btn, BorderLayout.SOUTH);

        return card;
    }

}
