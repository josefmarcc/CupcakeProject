package PresentationLayer;

import FunctionLayer.*;
import Util.CupcakePrice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Basket extends Command {

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

        request.setAttribute("totalprice", new CupcakePrice().calculateCupcakePrice(cupcake, qty));

        request.setAttribute("message","DU HAR LAGT DIN CUPCAKE(S) I KURVEN");

        


        return "../index";
    }

}
