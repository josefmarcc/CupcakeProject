package FunctionLayer;

import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static User newEmployee( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "employee");
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<User> customerList() {
        return UserMapper.getCustomerList();
    }

    public static String removeCustomer(String email){
        UserMapper userMapper = new UserMapper();
        return userMapper.deleteMember(email);
    }

    public static void changePassword(String password, String email) throws LoginSampleException {
        UserMapper.changePassword(password,email);
    }

}
