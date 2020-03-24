package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DeleteCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        ArrayList<Cupcake> basketList = (ArrayList<Cupcake>) session.getAttribute("basketlist");

        Cupcake cupcakeToRemove = (Cupcake) session.getAttribute("deletecupcakebutton");
        basketList.remove(cupcakeToRemove);

        session.getServletContext().setAttribute("basketlist", basketList);

        return "checkout";

    }

    public static void main(String[] args) {
        ArrayList<Cupcake> basketList = new ArrayList<>();
        Topping top = new Topping("Chokolade", 5);
        Bottom bot = new Bottom("Chokolade", 5);

        Cupcake cupcakeToRemove = new Cupcake(top,bot);
        basketList.add(cupcakeToRemove);
        Cupcake cupcake = cupcakeToRemove;
        System.out.println(basketList);
        if(cupcakeToRemove == cupcake) {
            basketList.remove(cupcakeToRemove);
        }
        System.out.println(basketList);
    }
}
