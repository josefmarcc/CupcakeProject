package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductMapper {





    public static void makeOrder(Cupcake cupcake, User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.ordertails (email, tname, bname, qty, total) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,user.getEmail());
            ps.setString(2, cupcake.getTop());
            ps.setString(3, cupcake.getBottom());
            ps.setInt(4, cupcake.getQty());
            ps.setInt(4, cupcake.getPrice());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    public static Cupcake makeCupcake(String top, String bottom) {
        Cupcake cupcake = new Cupcake();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.topping, cupcake.bottom";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                top = rs.getString("tname");
                bottom = rs.getString("bname");
                int price = rs.getInt("tPrice") + rs.getInt("bPrice");
                cupcake = new Cupcake(top, bottom, price);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return cupcake;
    }


    public static HashMap<String, Integer> getToppings() {
        HashMap<String, Integer> toppings = new HashMap<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.topping";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                String top = rs.getString("tname");
                int price = rs.getInt("tPrice");
                toppings.put(top,price);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return toppings;
    }


    public static HashMap<String, Integer> getBottoms() {
        HashMap<String, Integer> bottoms = new HashMap<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.bottom";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                String bottom= rs.getString("bname");
                int price = rs.getInt("bPrice");
                bottoms.put(bottom,price);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return bottoms;
    }


}
