package customeroperations;

import models.AsoStore;
import models.Customer;
import models.Product;

public interface CustomerInt {
    void addProductToCart(AsoStore asoStore,String productName, int quantity, Customer customer);

    void viewProductByCategory(Customer customer,String category, AsoStore asoStore);

}
