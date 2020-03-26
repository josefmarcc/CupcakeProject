package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Her er en klasse der fjerner kunder.
 * @author Thor, Hallur, Josef og Frederik
 */

public class RemoveCustomer extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter("email");
        LogicFacade.removeCustomer(email);

        HttpSession session = request.getSession();
        session.setAttribute("email",email);

        return "oversigt";
    }
}
