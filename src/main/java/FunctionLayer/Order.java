package FunctionLayer;

public class Order {
    private String topping, bottom, email;
    private int total, qty;

    public Order(String topping, String bottom, String email, int total, int qty) {
        this.topping = topping;
        this.bottom = bottom;
        this.email = email;
        this.total = total;
        this.qty = qty;
    }

    public String getTopping() {
        return topping;
    }

    public String getBottom() {
        return bottom;
    }

    public String getEmail() {
        return email;
    }

    public int getTotal() {
        return total;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Order{" +
                "topping='" + topping + '\'' +
                ", button='" + bottom + '\'' +
                ", email='" + email + '\'' +
                ", total=" + total +
                ", qty=" + qty +
                '}';
    }
}
