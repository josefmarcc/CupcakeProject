package Util;

import FunctionLayer.Bottom;
import FunctionLayer.Cupcake;
import FunctionLayer.Topping;

public class CupcakePrice {

    public double calculateCupcakePrice(Cupcake cupcake, int antal){
        return cupcake.getTotalPrice() * antal;
    }

}
