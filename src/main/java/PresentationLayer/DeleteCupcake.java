package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Her er en klasse der fjerner cupcakes fra kundens indkøbskurv.
 * @author Thor, Hallur, Josef og Frederik
 */

public class DeleteCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        ArrayList<Cupcake> basketList = (ArrayList<Cupcake>) session.getAttribute("basketlist");

        String cupcakeToRemove =  request.getParameter("deletecupcakebutton");

        for(int i = 0; i < basketList.size(); i++) {
            if(cupcakeToRemove.equals(basketList.get(i).toString())) {
                basketList.remove(i);
            }
        }

        session.setAttribute("basketlist", basketList);

        return "checkout";

    }

}
