package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
       if ( password1.equals( password2 ) ) {
           User user = LogicFacade.createUser( email, password1 );
           LogicFacade.login(email,password1);
           HttpSession session = request.getSession();
            //TODO FIX, den ved godt hvad credit er, men få det frem uden setCredit()
           user.setCredit(500);
           session.setAttribute("email",email);
           session.setAttribute("credit", user.showBalance());
           return "../index";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
