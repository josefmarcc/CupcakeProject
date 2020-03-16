package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductMapper {


    public static Cupcake makeCupcake(Topping top, Bottom bot) {
        return new Cupcake(top, bot);
    }

    public static Topping getTop(String name) {
        if (name != null) {
            int price = getToppingPrice(name);
            Topping top = new Topping(name, price);
            return top;
        }
        return null;
    }

    public static Bottom getBottom(String name) {
        if (name != null) {
            int price = getBottomPrice(name);
            Bottom bot = new Bottom(name, price);
            return bot;
        }
        return null;
    }


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

    public static int getToppingPrice(String name) {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT price FROM cupcake.topping + WHERE cupcake.topping.name = " + name + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            int price = 0;

            while (rs.next()) {
                price = rs.getInt("price");
            }
            return price;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;
    }


    public static int getBottomPrice(String name) {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT price FROM cupcake.bottom + WHERE cupcake.bottom.name = " + name + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            int price = 0;

            while (rs.next()) {
                price = rs.getInt("price");
            }
            return price;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;
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

}






