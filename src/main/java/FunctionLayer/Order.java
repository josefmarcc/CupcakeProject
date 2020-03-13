package FunctionLayer;

public class Order {
    private String topping, button, email;
    private int total, qty;

    public Order(String topping, String button, String email, int total, int qty) {
        this.topping = topping;
        this.button = button;
        this.email = email;
        this.total = total;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Order{" +
                "topping='" + topping + '\'' +
                ", button='" + button + '\'' +
                ", email='" + email + '\'' +
                ", total=" + total +
                ", qty=" + qty +
                '}';
    }
}
