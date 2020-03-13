package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static FunctionLayer.LogicFacade.customerList;

public class OrderList extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        ArrayList<User> customerList = LogicFacade.customerList();
        int customerAmount = customerList.size();
        HttpSession session = request.getSession();

        session.setAttribute("customerlist",customerList);
        session.setAttribute("customerAmount", customerAmount);

        return "index";
    }

}
