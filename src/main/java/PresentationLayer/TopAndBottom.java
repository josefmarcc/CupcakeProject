package PresentationLayer;

import DBAccess.ProductMapper;
import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class TopAndBottom extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        List<Topping> toppings = LogicFacade.getToppings();
        List<Bottom> bottoms = LogicFacade.getBottoms();

        request.setAttribute("toppings",toppings);
        request.setAttribute("bottoms",bottoms);

        return "index";
    }
}
