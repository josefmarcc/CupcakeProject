package Util;

import FunctionLayer.Bottom;
import FunctionLayer.Cupcake;
import FunctionLayer.Topping;

import java.util.List;

public class CupcakePrice {

    public double calculateCupcakePrice(Cupcake cupcake, int antal){
        return cupcake.getTotalPrice() * antal;
    }

    public double calculateBasketPrice(List<Cupcake> basketList, int qty){
        double price = 0;
        for(Cupcake cupcakes : basketList){
            price += calculateCupcakePrice(cupcakes, qty);
        }
        return price;
    }


}
