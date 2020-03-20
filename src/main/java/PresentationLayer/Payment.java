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
        int customerId = user.getId();
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

    public static void main(String[] args) {
        LogicFacade.createOrder(2);
        int orderId = LogicFacade.getOrderId(1);
        LogicFacade.addToBasket(orderId, 2, 50, 3, 4);
    }
        // addToBasket(int order_id, int qty, int sum, int topping_id, int bottom_id) {
}
