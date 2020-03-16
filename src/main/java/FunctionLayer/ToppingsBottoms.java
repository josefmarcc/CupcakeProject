package FunctionLayer;

import DBAccess.ProductMapper;

import java.util.List;

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
