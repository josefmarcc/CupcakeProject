package FunctionLayer;

public class Cupcake {

    private String top;
    private String bottom;
    private int price;
    private int qty;


    public Cupcake(String top, String bottom, int price) {
        this.top = top;
        this.bottom = bottom;
        this.price = price;
    }

    public Cupcake() {
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


    @Override
    public String toString() {
        return "Cupcake{" +
                " top: " + top +
                " bottom: " + bottom +
                " price: " + price +
                " qty: " + qty;
    }


}
