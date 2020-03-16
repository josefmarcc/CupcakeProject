package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Orderline;
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
            String SQL = "INSERT INTO cupcake.customer (email, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, credit, role FROM cupcake.customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "id" );
                int credit = rs.getInt( "credit" );
                String role = rs.getString( "role" );
                User user = new User( email, password );
                user.setId( id );
                user.setCredit(credit);
                user.setRole(role);
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Orderline> getOrderList() {
        ArrayList<Orderline> orderList = new ArrayList();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.orderline";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int orderlineid = rs.getInt("orderline_id");
                int orderid = rs.getInt("order_id");
                int qty = rs.getInt("qty");
                int sum = rs.getInt("sum");
                int toppingid = rs.getInt("topping_id");
                int bottomid = rs.getInt("bottom_id");
                Orderline orderline = new Orderline(orderlineid,orderid,qty,sum,toppingid,bottomid);
                orderList.add(orderline);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return orderList;
    }

    public static void deleteMember(String email) {
        try {
            String SQL = "DELETE FROM cupcake.customer WHERE email = (?)";
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
            String SQL = "UPDATE cupcake.customer SET password = (?) WHERE email = (?)";
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


