package PresentationLayer;

import FunctionLayer.LoginSampleException;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put("removecustomer", new RemoveCustomer());
        commands.put("orderlist", new OrderList());
        commands.put("changepassword", new ChangePassword());
        commands.put("logout", new LogoutSession());
        commands.put("deleteorder", new DeleteOrder());
        commands.put("addcredit", new AddCredit());
        commands.put( "redirect", new Redirect() );
        commands.put("addToBasket", new Basket());
        commands.put("deletecupcake", new DeleteCupcake());
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
