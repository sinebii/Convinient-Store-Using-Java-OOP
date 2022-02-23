package cashieroperations;

import enums.Gender;
import enums.Role;
import exceptions.CashierAuthorization;
import exceptions.DeclinedTransaction;
import models.AsoStore;
import models.Customer;
import models.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashierImpTest {

    private CashierImp cashierImp;
    private Staff staff;
    private Staff staff1;
    private Customer customer;
    private AsoStore asoStore;

    @Before
    public void setUp() throws Exception {
        cashierImp = new CashierImp();
        staff = new Staff("Sinebi","Innazo","Abuja", Gender.MALE, Role.MANAGER);
        staff1 = new Staff("Sinebi","Innazo","Abuja", Gender.MALE, Role.CASHIER);
        customer = new Customer("Aso","Adi","Kano",Gender.MALE);
        asoStore = new AsoStore("Decagon","Edo Tech Park","Decagon Ins");
    }

    @Test
    public void shouldCheckIfCustomerBalanceIsGreaterThanCartTotal() {
        customer.setWalletBalance(1000.90);
        customer.setCartTotal(56000.88);
        assertThrows(DeclinedTransaction.class,()-> cashierImp.checkOutCustomer(staff1,customer,asoStore));
    }

    @Test
    public void shouldCheckIfStaffIsACashier(){
        assertThrows(CashierAuthorization.class,()-> cashierImp.checkOutCustomer(staff,customer,asoStore));
    }


}