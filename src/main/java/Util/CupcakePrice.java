package Util;

import FunctionLayer.Cupcake;

import java.util.List;
/**
 * Her er en klasse der beregner cupcakepriser.
 * @author Thor, Hallur, Josef og Frederik
 */

public class CupcakePrice {

    public double calculateCupcakePrice(Cupcake cupcake, int antal){
        return cupcake.getTotalPrice() * antal;
    }

    public double calculateBasketPrice(List<Cupcake> basketList, List<Integer> qty){
        double price = 0;
        for(int i = 0; i < basketList.size() ; i++){
            price += calculateCupcakePrice(basketList.get(i), qty.get(i));
        }
        return price;
    }


}
