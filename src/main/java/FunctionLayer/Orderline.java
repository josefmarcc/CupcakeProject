package FunctionLayer;

import DBAccess.ProductMapper;

import java.util.ArrayList;

public class Orderline {


    private int orderlineid, orderid,qty,sum,toppingid,bottomid;

    public static ArrayList<Orderline> orderList;
    public static void initLists() {
        if (orderList == null) {
            orderList = LogicFacade.getOrderList();
        }
    }

    public Orderline(int orderlineid, int orderid, int qty, int sum, int toppingid, int bottomid) {
        this.orderlineid = orderlineid;
        this.orderid = orderid;
        this.qty = qty;
        this.sum = sum;
        this.toppingid = toppingid;
        this.bottomid = bottomid;
    }

    public int getOrderlineid() {
        return orderlineid;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getQty() {
        return qty;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum){
        this.sum = sum;
    }

    public int getToppingid() {
        return toppingid;
    }

    public int getBottomid() {
        return bottomid;
    }

    public String getToppingName(int id){
        return ProductMapper.getToppingName(id);
    }

    public String getBottomName(int id){
        return ProductMapper.getBottomName(id);
    }

}
