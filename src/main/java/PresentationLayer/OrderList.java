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

        ArrayList<Orderline> orderlist = LogicFacade.getOrderList();

        request.setAttribute("orderlist",orderlist);

        return "admin";
    }


}
