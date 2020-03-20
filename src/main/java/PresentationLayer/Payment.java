package PresentationLayer;

import FunctionLayer.*;
import sun.rmi.runtime.Log;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Payment extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        ServletContext context = request.getSession().getServletContext();

        User user = (User) context.getAttribute("user");
        int customerId = LogicFacade.getCustomerId(user.getEmail());
        LogicFacade.createOrder(customerId);


        int orderId = LogicFacade.getOrderId(user.getId());
        int qty = (int) session.getAttribute("qty");
        double sum = (double) session.getAttribute("price");
        Topping top = (Topping) session.getAttribute("top");
        Bottom bot = (Bottom) session.getAttribute("bot");
        int topping_id = top.getId();
        int bottom_id = bot.getId();

        LogicFacade.addToBasket(orderId, qty, (int)sum, topping_id, bottom_id);

        return "checkout";
    }

}
