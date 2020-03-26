package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Her er en klasse der fjerner en ordre fra databasen når der klikkes på knappen i table på JSP siden.
 * @author Thor, Hallur, Josef og Frederik
 */

public class DeleteOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int orderid = Integer.parseInt(request.getParameter("deletebutton"));
        LogicFacade.deleteOrder(orderid);
        new OrderList().execute(request,response);

        return "admin";

    }

}
