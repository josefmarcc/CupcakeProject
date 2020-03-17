package PresentationLayer;

import FunctionLayer.CustomerList;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddCredit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter("email");
        int saldo = Integer.parseInt(request.getParameter("saldo"));

        LogicFacade.addCredit(email, saldo);
        new OrderList().execute(request,response);

        List<User> customerList = LogicFacade.getCustomerList();
        request.setAttribute("customers", customerList);

        return "admin";

    }
}
