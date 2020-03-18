package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Basket extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int order_id = 1;
        int qty = (int)request.getAttribute("qty");
        int sum = 20;
        String topping_name = (String) request.getAttribute("toppingname");
        String bottom_name = (String) request.getAttribute("bottomname");

        int topping_id = 0;
        int bottom_id = 0;

        List<Topping> tops = LogicFacade.getToppings();
        List<Bottom> bottoms = LogicFacade.getBottoms();

        for(Topping top: tops){
            if(topping_name.equalsIgnoreCase(top.getName())){
                topping_id = top.getId();
            }
        }

        for(Bottom bottom: bottoms){
            if(bottom_name.equalsIgnoreCase(bottom.getName())){
                bottom_id = bottom.getId();
            }
        }

        LogicFacade.addToBasket(order_id, qty, sum, topping_id, bottom_id);

        return "checkout";
    }

}
