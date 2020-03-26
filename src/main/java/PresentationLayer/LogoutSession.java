package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Her er en klasse der logger brugeren ud og reseter værdier i navbar.
 * @author Thor, Hallur, Josef og Frederik
 */

public class LogoutSession extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        session.setAttribute("credit", null);
        session.setAttribute("email", null);
        session.invalidate();

        return "../index";
    }
}
