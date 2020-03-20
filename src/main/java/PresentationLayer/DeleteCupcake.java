package PresentationLayer;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DeleteCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Cupcake> basketList = Basket.getBasketList();
        HttpSession session = request.getSession();

        Cupcake cupcakeToRemove = (Cupcake) request.getParameter("deletebutton");
        Cupcake cupcake = (Cupcake)session.getAttribute("cupcake");
        if(cupcakeToRemove == cupcake) {
            basketList.remove(cupcakeToRemove);
        }
        Basket.setBasketList(basketList);

        return "checkout";


    }
}
