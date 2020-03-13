package FunctionLayer;

import DBAccess.UserMapper;
import DBAccess.ProductMapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String name, String email, String password) throws LoginSampleException {
        User user = new User(name, email, password);
        UserMapper.createUser(user);
        return user;
    }

    public static ArrayList<Order> getOrderList() {
        return UserMapper.getOrderList();
    }

    public static void removeCustomer(String email) {
        UserMapper.deleteMember(email);
    }

    public static void changePassword(String password, String email) throws LoginSampleException {
        UserMapper.changePassword(password, email);
    }

    // kald først getTopping og get bottom og så lav cupcake
    public static Cupcake makeCupcake(String top, String bottom) {
        HashMap<String, Integer> getToppings = ProductMapper.getToppings();
        HashMap<String, Integer> getBottoms = ProductMapper.getBottoms();

        Cupcake cupcake = new Cupcake();

        if (getToppings.containsKey(top) && getBottoms.containsKey(bottom)) {
            cupcake = ProductMapper.makeCupcake(top,bottom);
        }
        return cupcake;

    }

    public static void main(String[] args) {

        Cupcake cupcake = LogicFacade.makeCupcake("cool", "test");

        System.out.println(cupcake.toString());
        System.out.println(cupcake.getTop());
        System.out.println(cupcake.getBottom());
        System.out.println(cupcake.getPrice());
    }



}
