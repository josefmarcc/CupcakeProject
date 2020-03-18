package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String modtagerside = request.getParameter("modtagerside");

        switch (modtagerside){
            case "checkout":
                return "checkout";

            case "admin":
                new OrderList().execute(request, response);
                return "admin";

            default:
                return "index";
        }
    }
}
