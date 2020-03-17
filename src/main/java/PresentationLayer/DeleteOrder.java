package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int orderid = Integer.parseInt(request.getParameter("deletebutton"));
        LogicFacade.deleteOrder(orderid);
        new OrderList().execute(request,response);

        return "admin";

    }

}
