package FunctionLayer;

import DBAccess.ProductMapper;

import java.util.List;

public class ToppingsBottoms {

    private static List<Topping> toppingsList;
    private static List<Bottom> bottomsList;

    public static void initLists(){
        if(toppingsList == null){
            toppingsList = ProductMapper.getTops();
        }
        if(bottomsList == null){
            bottomsList = ProductMapper.getBottoms();
        }
    }

    public static List<Topping> getToppingsList() {
        return toppingsList;
    }

    public static List<Bottom> getBottomsList() {
        return bottomsList;
    }
}
