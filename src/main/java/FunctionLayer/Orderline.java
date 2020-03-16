package FunctionLayer;

public class Orderline {

    private final int orderlineid, orderid,qty,sum,toppingid,bottomid;

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

    public int getToppingid() {
        return toppingid;
    }

    public int getBottomid() {
        return bottomid;
    }
}
