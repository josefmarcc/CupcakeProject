package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrder extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int orderid = (int) request.getAttribute("orderid");
        LogicFacade.deleteOrder(orderid);
        new OrderList().execute(request,response);

        return "admin";

    }
}
