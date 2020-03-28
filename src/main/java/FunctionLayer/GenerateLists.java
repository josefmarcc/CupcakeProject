package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Her er en klasse der laver lister af bottom og topping objekter hentet fra DB.
 * @author Thor, Hallur, Josef og Frederik
 */

public class GenerateLists {

    private static List<Topping> toppingsList;
    private static List<Bottom> bottomsList;
    private ArrayList<Double> priceList = new ArrayList<>();
    private ArrayList<Integer> qtyList = new ArrayList<>();
    private  ArrayList<Cupcake> basketList = new ArrayList<>();

    public static void initLists(){
        if(toppingsList == null){
            toppingsList = LogicFacade.getToppings();
        }
        if(bottomsList == null){
            bottomsList = LogicFacade.getBottoms();
        }
    }

    public void initPayList(){
        if(priceList == null){
            priceList = new ArrayList<>();
        }
        if(qtyList == null){
            qtyList = new ArrayList<>();
        }
        if(basketList == null){
            basketList = new ArrayList<>();
        }
    }

    public static List<Topping> getToppingsList() {
        return toppingsList;
    }

    public static List<Bottom> getBottomsList() {
        return bottomsList;
    }

    public ArrayList<Double> getPriceList() {
        return priceList;
    }

    public ArrayList<Integer> getQtyList() {
        return qtyList;
    }

    public ArrayList<Cupcake> getBasketList() {
        return basketList;
    }

}
