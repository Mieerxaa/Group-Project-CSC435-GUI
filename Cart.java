import java.util.ArrayList;
import java.util.List;

public class Cart {

    public static List<CartItem> cartItems = new ArrayList<>();

    public static class CartItem {
        public String name;
        public double price;
        public int quantity;

        public CartItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    public static void addItem(String name, double price, int quantity) {
        for (CartItem item : cartItems) {
            if (item.name.equals(name)) {
                item.quantity += quantity;
                return;
            }
        }
        cartItems.add(new CartItem(name, price, quantity));
    }

    public static void clearCart() {
        cartItems.clear();
    }

    public static double getTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.price * item.quantity;
        }
        return total;
    }
}
