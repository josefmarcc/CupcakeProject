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


public class OrderList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();


        ArrayList<Orderline> orderlist = LogicFacade.getOrderList();
        for (Orderline ol: orderlist){
                ol.setSum((Integer) session.getAttribute("admin"));
        }
        request.getServletContext().setAttribute("orderlist",orderlist);

        return "admin";
    }


}
