package FunctionLayer;

public class Topping {

    private int id;
    private final String name;
    private final double price;

    public Topping( String name, int price) {
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Top{" + "name=" + name + ", price=" + price + '}';
    }



}
