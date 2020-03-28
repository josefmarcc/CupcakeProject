package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Orderline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
/**
 * Her er en klasse der laver en liste af orderline, som benyttes til at vise alle ordrelines på admin siden.
 * @author Thor, Hallur, Josef og Frederik
 */

public class OrderList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ArrayList<Orderline> orderlist = LogicFacade.getOrderList();

        request.getServletContext().setAttribute("orderlist",orderlist);

        return "admin";
    }


}
