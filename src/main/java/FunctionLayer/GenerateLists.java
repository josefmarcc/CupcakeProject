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
    private static ArrayList<Double> priceList = new ArrayList<>();
    private static ArrayList<Integer> qtyList = new ArrayList<>();
    private static ArrayList<Cupcake> basketList = new ArrayList<>();

    public static void initLists(){
        if(toppingsList == null){
            toppingsList = LogicFacade.getToppings();
        }
        if(bottomsList == null){
            bottomsList = LogicFacade.getBottoms();
        }
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

    public static ArrayList<Double> getPriceList() {
        return priceList;
    }

    public static ArrayList<Integer> getQtyList() {
        return qtyList;
    }

    public static ArrayList<Cupcake> getBasketList() {
        return basketList;
    }

}
