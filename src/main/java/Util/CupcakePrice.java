package Util;

import FunctionLayer.Bottom;
import FunctionLayer.Cupcake;
import FunctionLayer.Topping;

import java.util.List;

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
