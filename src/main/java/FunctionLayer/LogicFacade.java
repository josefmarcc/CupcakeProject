package FunctionLayer;

import DBAccess.UserMapper;
import DBAccess.ProductMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password);
        UserMapper.createUser(user);
        return user;
    }

    public static ArrayList<Orderline> getOrderList() {
        return UserMapper.getOrderList();
    }

    public static void removeCustomer(String email) {
        UserMapper.deleteMember(email);
    }

    public static void changePassword(String password, String email) throws LoginSampleException {
        UserMapper.changePassword(password, email);
    }

    public static List<Topping> getToppings(){
        return ProductMapper.getTops();
    }

    public static List<Bottom> getBottoms(){
        return ProductMapper.getBottoms();
    }

    public static List<User> getCustomerList(){
        return UserMapper.getCustomerList();
    }
}
