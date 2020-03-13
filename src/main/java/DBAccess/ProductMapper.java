package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductMapper {


    public Cupcake makeCupcake(Topping top, Bottom bot) {
        return new Cupcake(top, bot);
    }

    public Topping getTop(String name) {
        if (name != null) {
            int price = getToppingPrice(name);
            Topping top = new Topping(name, price);
            return top;
        }
        return null;
    }

    public Bottom getBottom(String name) {
        if (name != null) {
            int price = getBottomPrice(name);
            Bottom bot = new Bottom(name, price);
            return bot;
        }
        return null;
    }


    public List<Topping> getTops() {
        List<Topping> toppings = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.topping";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("tname");
                int price = rs.getInt("tPrice");
                Topping top = new Topping(name, price);
                toppings.add(top);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return toppings;
    }

    public List<Bottom> getBottoms() {
        List<Bottom> bottoms = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM cupcake.bottom";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String name = rs.getString("bname");
                int price = rs.getInt("bPrice");
                Bottom bottom = new Bottom(name, price);
                bottoms.add(bottom);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return bottoms;
    }

    public int getToppingPrice(String name) {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT tPrice FROM cupcake.topping + WHERE cupcake.topping.tname = " + name + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            int price = 0;

            while (rs.next()) {
                price = rs.getInt("tPrice");
            }
            return price;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;
    }


    public int getBottomPrice(String name) {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT bPrice FROM cupcake.bottom + WHERE cupcake.bottom.bname = " + name + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            int price = 0;

            while (rs.next()) {
                price = rs.getInt("bPrice");
            }
            return price;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;
    }




}
