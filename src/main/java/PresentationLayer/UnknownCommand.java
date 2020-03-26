package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
Exception klasse der udløser panik.

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String msg = "Unknown command. Contact IT";
        throw new LoginSampleException( msg );
    }

}
