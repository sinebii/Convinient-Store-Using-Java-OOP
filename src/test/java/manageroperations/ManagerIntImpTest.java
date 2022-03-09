package manageroperations;

import enums.Gender;
import enums.Role;
import exceptions.AddProductsToStoreException;
import models.AsoStore;
import models.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerIntImpTest {
    ManagerIntImp managerIntImp;
    Staff staff;
    AsoStore asoStore;


    @Before
    public void setUp() throws Exception {
        managerIntImp = new ManagerIntImp();
        staff = new Staff("Kunlay","Ade","Kaduna", Gender.MALE, Role.CASHIER);
    }

    @Test
    public void shouldTestThatOnlyManagerCanAddToStore() {
       assertThrows(AddProductsToStoreException.class, ()-> managerIntImp.addProductsToStore(staff,asoStore));
    }




}