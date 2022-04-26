package customeroperations;

import enums.Gender;
import exceptions.OutOfStockException;
import models.AsoStore;
import models.Customer;
import models.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerImpTest {
    CustomerImp customerImp;
    AsoStore asoStore;
    Customer customer;

    @Before
    public void setUp() throws Exception {
        customerImp = new CustomerImp();
        asoStore = new AsoStore("Degacon","address","Musa");
        customer = new Customer("Sinebi","Innazo","Abuja", Gender.MALE);
    }

    @Test
    public void customerShouldAddProductToCart() {

        customerImp.addProductToCart(asoStore,"Samsung S9",2,customer);
        customerImp.addProductToCart(asoStore,"Samsung S9",1,customer);
        assertEquals(3,customer.getMyCart().getProductQuantity());
    }

    @Test
    public void CustomerShouldRemoveProductFromCart(){
        customerImp.addProductToCart(asoStore,"Samsung S9",2,customer);
        assertNull(customerImp.clearCart(customer));
    }

    @Test
    public void customerShouldAddMoneyToWallet() {
        customer.setWalletBalance(6000.0);
        customer.setWalletBalance(3000.00);
        double customerBalanceAfter = customer.getWalletBalance();
        assertEquals(9000.00,customerBalanceAfter,0.00);
    }

    @Test
    public void shouldCheckIfProductionStoreIsGreaterThanWhatCustomerWant(){
        int productQuantity = 0;

        for(Product product: asoStore.getListofProducts()){
            if(product.getProductName().equals("Samsung S9")){
                if(product.getProductQuantity()>2){
                    productQuantity = product.getProductQuantity();
                    break;
                }
            }
        }

        assertTrue(productQuantity > customer.getMyCart().getProductQuantity());

    }


}

