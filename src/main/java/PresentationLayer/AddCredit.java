package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Her er en klasse der tilføjer credit til en brugers balance i databasen.
 * @author Thor, Hallur, Josef og Frederik
 */

public class AddCredit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter("email");
        int saldo = Integer.parseInt(request.getParameter("saldo"));

        LogicFacade.addCredit(email, saldo);

        request.getServletContext().setAttribute("customerList",  LogicFacade.getCustomerList());

        return "admin";

    }
}
