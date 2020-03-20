package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductMapper {

    public static List<Topping> getTops() {
        List<Topping> toppings = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.topping";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Topping top = new Topping(name, price);
                toppings.add(top);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return toppings;
    }

    public static List<Bottom> getBottoms() {
        List<Bottom> bottoms = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.bottom";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Bottom bottom = new Bottom(name, price);
                bottoms.add(bottom);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return bottoms;
    }

    public static String getToppingName(int id) {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT topping_name FROM cupcake.customer_view where topping_id =" + id + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            String toppingname = "";

            while (rs.next()) {
                toppingname = rs.getString("topping_name");
            }
            return toppingname;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return "FEJLTOPPING";
    }

    public static String getBottomName(int id) {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT bottom_name FROM cupcake.customer_view where bottom_id =" + id + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            String bottomname = "";

            while (rs.next()) {
                bottomname = rs.getString("bottom_name");
            }
            return bottomname;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return "FEJLBUND";
    }

    public static int getOrderId(int customerId){
       int orderId = 0;

        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.order where customer_id = " + customerId + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            orderId = 0;

            while (rs.next()) {
                orderId = rs.getInt("order_id");
            }
            return orderId;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return orderId;
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
                Orderline orderline = new Orderline(orderlineid, orderid, qty, sum, toppingid, bottomid);
                orderList.add(orderline);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return orderList;
    }


    public static void deleteOrder(int order_id) {
        try {
            String SQL = "DELETE FROM cupcake.orderline where order_id =" + order_id + ";";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            ps.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke fjerne order");
        }
    }

    public static void addCredit(String email, int credit) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcake.customer SET credit = credit + (?) WHERE email = (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, credit);
            ps.setString(2, email);
            ps.execute();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke finde bruger");
        }
    }

    public static void createOrder(int customerId){
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.order (customer_id ) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerId);

            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke finde lave en ordre");
        }
    }


    public static void addToBasket(int order_id, int qty, int sum, int topping_id, int bottom_id) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcake.orderline (order_id, qty, sum, topping_id, bottom_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order_id);
            ps.setInt(2, qty);
            ps.setInt(3, sum);
            ps.setInt(4, topping_id);
            ps.setInt(5, bottom_id);
            ps.execute();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke finde oprette orderline");
        }
    }

}






