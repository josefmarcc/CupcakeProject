package FunctionLayer;

public class Topping {

    private final String name;
    private final int price;

    public Topping(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Top{" + "name=" + name + ", price=" + price + '}';
    }



}
