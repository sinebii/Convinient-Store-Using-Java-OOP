package cashieroperations;

import models.AsoStore;
import models.Customer;
import models.Product;

public interface CustomerCashierInterface {
    default double cartTotal(Customer customer, AsoStore asoStore){
        double cost = 0.00;
        for(Product each:asoStore.getListofProducts()){
            if(each.getProductName().equals(customer.getMyCart().getProductName())){
                cost =each.getProductPrice()*customer.getMyCart().getProductQuantity();
                customer.setCartTotal(cost);
            }
        }

        return  customer.getCartTotal();
    }
}
