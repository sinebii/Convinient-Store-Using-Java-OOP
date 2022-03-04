package cashieroperations;

import models.AsoStore;
import models.Customer;
import models.Staff;

import java.io.IOException;

public interface CashierInt {
    void checkOutCustomer(Staff staff,Customer customer,AsoStore asoStore) throws IOException;

}
