package FunctionLayer;

public class Bottom {

    private int id;
    private final String name;
    private final double price;

    public Bottom(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Bottom{" + "name=" + name + ", price=" + price + '}';
    }


}
