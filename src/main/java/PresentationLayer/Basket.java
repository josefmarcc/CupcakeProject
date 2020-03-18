package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Basket extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        int order_id = (int) session.getAttribute("order_id");
        int qty = (int) session.getAttribute("qty");
        int sum = (int) session.getAttribute("sum");
        String topping_name = (String) session.getAttribute("btn1");
        String bottom_name = (String) session.getAttribute("btn2");

        LogicFacade.addToBasket(order_id, qty, sum, topping_id, bottom_id);


        return "index";
    }
}
