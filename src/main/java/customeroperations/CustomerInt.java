package customeroperations;

import models.AsoStore;
import models.Customer;

public interface CustomerInt {

    void addProductToCart(AsoStore asoStore,String productName, int quantity, Customer customer);
    //void removeProductFromCart(String productName,Customer customer);
    void cartTotal(Customer customer);
}
