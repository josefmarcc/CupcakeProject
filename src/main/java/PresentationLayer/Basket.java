package PresentationLayer;

import FunctionLayer.*;
import Util.CupcakePrice;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Her er en klasse der laver tager de elementer en kunde har puttet i indkøbskurven og gemmer dem i lister.
 * Dette gør at de fremgår på checkout.jsp siden i en table.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Basket extends Command {
    private static ArrayList<Cupcake> basketList = new ArrayList<>();
    private static ArrayList<Double> priceList = new ArrayList<>();
    private static ArrayList<Integer> qtyList = new ArrayList<>();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int qty = Integer.parseInt(request.getParameter("qty"));
        String topping_name = request.getParameter("toppingname");
        String bottom_name = request.getParameter("bottomname");

        Topping topping = null;
        Bottom bottom = null;

        for (Topping top : LogicFacade.getToppings()) {
            if (topping_name.equals(top.getName())) {
                topping = top;
            }
        }
        for (Bottom bot :  LogicFacade.getBottoms()){
            if (bottom_name.equals(bot.getName())) {
                bottom = bot;
            }
        }

        Cupcake cupcake = new Cupcake(topping, bottom);

        request.setAttribute("message","DU HAR LAGT DIN CUPCAKE(S) I KURVEN");

        double price = new CupcakePrice().calculateCupcakePrice(cupcake, qty);
        basketList.add(cupcake);
        qtyList.add(qty);
        priceList.add(price);

        HttpSession session = request.getSession();
        session.setAttribute("qty", qty);
        session.setAttribute("price", price);
        session.setAttribute("priceList", priceList);
        session.setAttribute("qtyList", qtyList);
        session.setAttribute("basketlist", basketList);
        session.setAttribute("basketprice", new CupcakePrice().calculateBasketPrice(basketList,qtyList));
        session.setAttribute("top", topping);
        session.setAttribute("bot",bottom);

        return "../index";
    }

}
