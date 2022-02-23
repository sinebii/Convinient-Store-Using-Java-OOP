package customeroperations;

import enums.Gender;
import models.AsoStore;
import models.Customer;
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

        customerImp.addProductToCart(asoStore,"Samsung S9",5,customer);
        assertEquals(1,customer.getCart().size());
    }

    @Test
    public void thisShouldCalculateCustomerCartTotal() {
        double customerB = customer.getCartTotal();
        customerImp.addProductToCart(asoStore,"Samsung S9",5,customer);
        double customerAfter = customer.getCartTotal();
        assertTrue(customerB < customerAfter);
    }

    @Test
    public void thisShouldAddMoneyToCustomerWallet() {
        double customerBalanceBefore = customer.getWalletBalance();
        customer.setWalletBalance(6000.0);
        double customerBalanceAfter = customer.getWalletBalance();
        assertEquals(6000.00,customerBalanceAfter,0.00);
    }
}