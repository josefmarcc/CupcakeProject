package FunctionLayer;

/**
 * Her er en klasse der laver cupcake objekter baseret på toppe og bottom objekter.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Cupcake {

    private Topping top;
    private Bottom bottom;
    private double totalPrice;


    public Cupcake(Topping top, Bottom bottom) {
        this.top = top;
        this.bottom = bottom;
        this.totalPrice = top.getPrice() + bottom.getPrice();
    }

    public Topping getTop() {
        return top;
    }

    public void setTop(Topping top) {
        this.top = top;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Cupcake() {
    }



    @Override
    public String toString() {
        return "Cupcake{" +
                " top: " + top +
                " bottom: " + bottom +
                " price: " + totalPrice;
    }


}
