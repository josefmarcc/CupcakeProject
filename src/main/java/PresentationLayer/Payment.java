package PresentationLayer;

import DBAccess.ProductMapper;
import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Her er en klasse der muliggør betaling, en kundes balance ændres og opdateres i DB.
 * Kurven tømmes for data og samlet pris sættes til nul.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Payment extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        ServletContext context = request.getSession().getServletContext();

        User user = (User) context.getAttribute("user");
        if(user == null){
            request.setAttribute("message","HOV, HUSK AT LOGGE IND INDEN DU KLIKKER BETAL");
            return "checkout";
        } else {
            double totalPrice = (double) session.getAttribute("basketprice");

            if (user.getCredit() >= totalPrice) {
                String email = user.getEmail();
                int customerId = LogicFacade.getCustomerId(email);
                LogicFacade.createOrder(customerId);

                double sum = (double) session.getAttribute("price");
                int orderId = LogicFacade.getOrderId(user.getId());
                int qty = (int) session.getAttribute("qty");

                Topping top = (Topping) session.getAttribute("top");
                Bottom bot = (Bottom) session.getAttribute("bot");
                int topping_id = top.getId();
                int bottom_id = bot.getId();

                LogicFacade.addToBasket(orderId, qty, (int) sum, topping_id, bottom_id);
                String accepted = "DIN ORDRER ER BLEVET BETALT OG KAN HENTES OM 10 MIN";
                request.setAttribute("message", accepted);

                int updatedCredit = (int) (user.getCredit() - totalPrice);
                ProductMapper.updateCredit(email, updatedCredit);

                user.setCredit(updatedCredit);
                session.setAttribute("credit", user.showBalance());

                //Tømmer arraylist + sætter pris til 0.
                ArrayList<Cupcake> basketlist = (ArrayList<Cupcake>) session.getAttribute("basketlist");
                basketlist.clear();
                session.setAttribute("basketlist", basketlist);
                session.setAttribute("basketprice", null);

            } else {
                String rejected = "DER ER ET PROBLEM MED DIN ØKONOMISKE SITUATION";
                request.setAttribute("message", rejected);
            }
        }

        return "checkout";
    }


}
