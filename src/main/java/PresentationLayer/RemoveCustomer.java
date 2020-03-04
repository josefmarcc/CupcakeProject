package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveCustomer extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        String s = LogicFacade.removeCustomer(request.getParameter("email"));
        HttpSession session = request.getSession();

        session.setAttribute("email",s);
        return "oversigt";
    }
}
