import javax.swing.*;
import java.awt.*;

public class CategoryPage extends JFrame {

    public CategoryPage() {
        setTitle("BTS Category");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        // ===== TITLE =====
        JLabel title = new JLabel("BTS", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 40));
        title.setBounds(350, 30, 200, 50);
        panel.add(title);

        // ===== CART BUTTON =====
        JButton cartBtn = new JButton("cart");
        cartBtn.setBounds(780, 30, 80, 30); // top-right
        panel.add(cartBtn);

        cartBtn.addActionListener(e -> {
            new CartPage();
            dispose();
        });


        // ===== IMAGE =====
        ImageIcon icon = new ImageIcon(Main.class.getResource("image/BTS-LOGO.jpg"));
        Image img = icon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(100, 120, 200, 250);
        panel.add(imageLabel);

        // ===== BUTTONS =====
        JButton backBtn = new JButton("back");
        backBtn.setBounds(30, 30, 80, 30);
        panel.add(backBtn);

        JButton albumBtn = new JButton("Album");
        albumBtn.setBounds(450, 150, 150, 50);
        panel.add(albumBtn);

        JButton lightstickBtn = new JButton("Lightstick");
        lightstickBtn.setBounds(620, 150, 150, 50);
        panel.add(lightstickBtn);

        JButton pictureBtn = new JButton("Photocards");
        pictureBtn.setBounds(535, 230, 150, 50);
        panel.add(pictureBtn);

        // ===== NAVIGATION =====
        backBtn.addActionListener(e -> {
            new GroupListPage();
            dispose();
        });

        albumBtn.addActionListener(e -> {
            new AlbumPage();
            dispose();
        });

        lightstickBtn.addActionListener(e -> {
            new LightstickPage();
            dispose();
        });

        pictureBtn.addActionListener(e -> {
            new PhotocardPage();
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}
