package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Her er en klasse der laver en liste af orderline, som benyttes til at vise alle ordrelines på admin siden.
 * @author Thor, Hallur, Josef og Frederik
 */

public class OrderList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();


        ArrayList<Orderline> orderlist = LogicFacade.getOrderList();
        for (Orderline ol: orderlist){
                ol.setSum((Integer) session.getAttribute("deletebutton"));
        }
        request.getServletContext().setAttribute("orderlist",orderlist);

        return "admin";
    }


}
