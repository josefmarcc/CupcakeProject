package PresentationLayer;

import FunctionLayer.CustomerList;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCredit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter("email");
        int saldo = Integer.parseInt(request.getParameter("saldo"));

        LogicFacade.addCredit(email, saldo);
        new OrderList().execute(request,response);

        request.setAttribute("customers", new CustomerList().getCustomerList());

        return "admin";

    }
}
