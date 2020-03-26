package FunctionLayer;

/**
 * Her er en klasse der laver bottom objekter.
 * @author Thor, Hallur, Josef og Frederik
 */
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bottom{" + "name=" + name + ", price=" + price + '}';
    }


}
