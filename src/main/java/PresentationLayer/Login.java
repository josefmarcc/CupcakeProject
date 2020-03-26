package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Her er en klasse der gør at kunden kan logge ind, hvis det er en admin der logger ind viderestilles administratoren til admin.jsp.
 * @author Thor, Hallur, Josef og Frederik
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("credit", user.showBalance());
        session.getServletContext().setAttribute("user", user);

        switch (email){
            case "admin":
                return "admin";
            default: return "../index";
        }

    }

}
