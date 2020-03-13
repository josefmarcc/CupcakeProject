package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The purpose of UserMapper is to...
 *
 * @author Josef
 */
public class UserMapper {


    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.users (name, email, password, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4,500);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name, balance FROM cupcake.users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                User user = new User(name, email, password);
                user.setName(name);
                user.setBalance(balance);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    public static ArrayList<User> getCustomerList() {
        ArrayList<User> customerList = new ArrayList();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.users";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User user = new User( name, email, password);
                customerList.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return customerList;
    }

    public static void deleteMember(String email) {
        try {
            String SQL = "DELETE FROM cupcake.users WHERE email = (?)";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.execute();
            ps.close();


        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke fjerne medlem.");
        }
    }

    public static void changePassword(String password, String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcake.users SET password = (?) WHERE email = (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}


