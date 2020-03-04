package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassword extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {



        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );

        LogicFacade.changePassword( password, email);

        HttpSession session = request.getSession();
        session.setAttribute("email",email);
        session.setAttribute("password",password);

        return "oversigt";
    }
}
