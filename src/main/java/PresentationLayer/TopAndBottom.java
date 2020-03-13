package PresentationLayer;

import DBAccess.ProductMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class TopAndBottom extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<String> toppings = ProductMapper.getToppings();
        ArrayList<String> bottoms = ProductMapper.getBottoms();

        request.setAttribute("toppings",toppings);
        request.setAttribute("bottoms",bottoms);


        return "index";
    }
}
