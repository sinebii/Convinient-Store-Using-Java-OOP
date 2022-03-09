package cashieroperations;

import models.AsoStore;
import models.Customer;
import models.Staff;

import java.io.IOException;
import java.util.concurrent.Callable;

public interface CashierInt {
    Callable<String> checkOutCustomer(Staff staff, Customer customer, AsoStore asoStore) throws IOException;

}
