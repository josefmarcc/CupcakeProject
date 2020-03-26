package FunctionLayer;

import java.util.List;

/**
 * Her er en klasse der laver en liste af kunder.
 * @author Thor, Hallur, Josef og Frederik
 */

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

    public static void updateCustomerList(){
        LogicFacade.getCustomerList();
    }
}
