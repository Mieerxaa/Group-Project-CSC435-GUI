import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptHelper {

    public static void saveReceipt(String name, String address, String phone, String paymentMethod, double totalAmount) {
        try {
            // FileWriter with 'true' -> append mode
            PrintWriter writer = new PrintWriter(new FileWriter("receipt.txt", true));

            // Add a timestamp for each purchase
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println("===== PURCHASE ON " + timestamp + " =====");

            writer.println("Customer Name   : " + name);
            writer.println("Address         : " + address);
            writer.println("Phone Number    : " + phone);
            writer.println("Payment Method  : " + paymentMethod);
            writer.println("------------------------------------------\n");

            writer.printf("%-20s %-5s %-10s\n", "Product", "Qty", "Subtotal");
            writer.println("------------------------------------------");

            for (Cart.CartItem item : Cart.cartItems) {
                double subtotal = item.price * item.quantity;
                writer.printf("%-20s %-5d RM%-8.2f\n", item.name, item.quantity, subtotal);
            }

            writer.println("\nTOTAL: RM " + String.format("%.2f", totalAmount));
            writer.println("\n\n"); // extra spacing for next receipt

            writer.close();

            System.out.println("Receipt appended successfully to receipt.txt");
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
