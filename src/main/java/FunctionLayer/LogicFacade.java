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
        return ProductMapper.getOrderList();
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

    public static void deleteOrder(int orderid){
        ProductMapper.deleteOrder(orderid);
    }

    public static void addCredit(String email, int credit){
        ProductMapper.addCredit(email,credit);
    }

    public static void addToBasket(int order_id, int qty, int sum, int topping_id, int bottom_id) { ProductMapper.addToBasket(order_id, qty, sum, topping_id, bottom_id);}

    public static List<User> getCustomerList(){
        return UserMapper.getCustomerList();
    }

    public static int getCustomerId(String email){
        return UserMapper.getCustomerId(email);
    }

    public static void createOrder(int customerId){
        ProductMapper.createOrder(customerId);
    }

    public static int getOrderId(int customerId){
        return ProductMapper.getOrderId(customerId);
    }
}
