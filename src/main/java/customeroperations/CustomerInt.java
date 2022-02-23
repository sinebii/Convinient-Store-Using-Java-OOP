package customeroperations;

import models.AsoStore;
import models.Customer;

public interface CustomerInt {
<<<<<<< HEAD

=======
    void viewAllProducts(AsoStore asoStore,Customer customer);
>>>>>>> f45fa48 (My Week_two first upload)
    void addProductToCart(AsoStore asoStore,String productName, int quantity, Customer customer);
    //void removeProductFromCart(String productName,Customer customer);
    void cartTotal(Customer customer);
}
