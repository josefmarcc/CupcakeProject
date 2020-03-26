package FunctionLayer;

import DBAccess.ProductMapper;

import java.util.List;

/**
 * Her er en klasse der laver lister af bottom og topping objekter hentet fra DB.
 * @author Thor, Hallur, Josef og Frederik
 */

public class ToppingsBottoms {

    private static List<Topping> toppingsList;
    private static List<Bottom> bottomsList;

    public static void initLists(){
        if(toppingsList == null){
            toppingsList = LogicFacade.getToppings();
        }
        if(bottomsList == null){
            bottomsList = LogicFacade.getBottoms();
        }

    }

    public static List<Topping> getToppingsList() {
        return toppingsList;
    }

    public static List<Bottom> getBottomsList() {
        return bottomsList;
    }
}
