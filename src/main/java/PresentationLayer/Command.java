package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.ejb.Remove;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put("newemployee", new NewEmployee());
        commands.put("removecustomer", new RemoveCustomer());
        commands.put("customerlist", new CustomerList());
        commands.put("changepassword", new ChangePassword());
        commands.put("logout", new LogoutSession());
    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "taget" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException;

}
