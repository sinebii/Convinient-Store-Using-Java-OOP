package cashieroperations;

import models.AsoStore;
import models.Customer;
import models.Staff;

public interface CashierInt {
    void checkOutCustomer(Staff staff, Customer customer, AsoStore asoStore);
    void generateReceipt(Staff staff,Customer customer,AsoStore asoStore);
}
