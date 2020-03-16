package FunctionLayer;

import java.util.List;

public class CustomerList {

    public static List<User> customerList;

    public static void initLists(){
        if(customerList == null){
            customerList = LogicFacade.getCustomerList();
        }

    }

    public static List<User> getCustomerList() {
        return customerList;
    }
}
