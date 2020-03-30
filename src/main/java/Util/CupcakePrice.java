package Util;

import FunctionLayer.Cupcake;

import java.util.List;

/**
 * Her er en klasse der beregner cupcakepriser.
 * @author Thor, Hallur, Josef og Frederik
 */

public class CupcakePrice {

    /**
     * @param cupcake - hvilken cupcake der skal udregnes pris for
     * @param antal - antal af cupcakes der skal udregnes pris for
     * @return - retunerer en double som er prisen på X antal cupcakes
     */
    public double calculateCupcakePrice(Cupcake cupcake, int antal) {
        return cupcake.getTotalPrice() * antal;
    }
    /**
     * @param basketList - hvilken liste af cupcakes der skal udregnes pris for
     * @param qty - liste med antal af cupcakes der skal udregnes pris for
     * @return - retunerer en double som er prisen på X antal cupcakes
     * Metoden benyttes til at udregne prisen for den samlede kurv, hvilket er årsagen til de 2 liste parametre.
     */
    public double calculateBasketPrice(List<Cupcake> basketList, List<Integer> qty) {
        double price = 0;
        for (int i = 0; i < basketList.size(); i++) {
            price += calculateCupcakePrice(basketList.get(i), qty.get(i));
        }
        return price;
    }


}
