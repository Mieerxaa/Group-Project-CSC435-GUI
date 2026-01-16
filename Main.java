import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setTitle("KPOP ONLINE MERCHANDISE");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== TOP PANEL (Title + Buttons) =====
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // ===== TITLE =====
        JLabel title = new JLabel("KPOP ONLINE MERCHANDISE", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setPreferredSize(new Dimension(800, 80));
        topPanel.add(title, BorderLayout.NORTH);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));

        JButton enterButton = new JButton("Enter");
        JButton exitButton = new JButton("Exit");

        enterButton.setPreferredSize(new Dimension(160, 50));
        exitButton.setPreferredSize(new Dimension(160, 50));

        enterButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 20));

        enterButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        buttonPanel.add(enterButton);
        buttonPanel.add(exitButton);

        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        // ===== ACTIONS =====
        enterButton.addActionListener(e -> {
            new GroupListPage();
            dispose();
        });

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
