package cashieroperations;

import customeroperations.CustomerImp;
import enums.Gender;
import enums.Role;
import exceptions.CashierAuthorization;
import exceptions.CustomerInsufficientFunds;
import exceptions.DeclinedTransaction;
import models.AsoStore;
import models.Customer;
import models.Product;
import models.Staff;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CashierImpTest {

    private CashierImp cashierImp;
    private Staff staff;
    private Staff staff1;
    private Customer customer;
    private AsoStore asoStore;
    private CustomerImp customerImp;
    private Product product;

    @Before
    public void setUp() throws Exception {
        cashierImp = new CashierImp();
        customerImp = new CustomerImp();
        product = new Product("iPhone 7","iPhone",70000.00,15);
        staff = new Staff("Sinebi","Innazo","Abuja", Gender.MALE, Role.MANAGER);
        staff1 = new Staff("Sinebi","Innazo","Abuja", Gender.MALE, Role.CASHIER);
        customer = new Customer("Aso","Adi","Kano",Gender.MALE);
        asoStore = new AsoStore("Decagon","Edo Tech Park","Decagon Ins");


    }

    @Test
    public void shouldCheckIfCustomerBalanceIsGreaterThanCartTotal() {
        customer.setWalletBalance(1000.50);
        customerImp.addProductToCart(asoStore,"iPhone 7",1,customer);
        assertThrows(CustomerInsufficientFunds.class,()-> cashierImp.checkOutCustomer(staff1,customer,asoStore));
    }
    @Test
    public void shouldCheckoutCustomer() throws IOException {

        customer.setWalletBalance(400000000.90);
        customerImp.addProductToCart(asoStore,"iPhone 7",1,customer);
        cashierImp.checkOutCustomer(staff1,customer,asoStore);
        assertEquals(0,customer.getMyCart().getProductQuantity());
        assertEquals(null,customer.getMyCart().getProductName());
        //assertEquals(14,cashierImp.checkOutCustomer(staff1,customer,asoStore));
    }

    @Test
    public void shouldCheckIfStaffIsACashier(){
        assertThrows(CashierAuthorization.class,()-> cashierImp.checkOutCustomer(staff,customer,asoStore));
    }


}