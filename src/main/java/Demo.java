import cashieroperations.CashierImp;
import customeroperations.CustomerImp;
import enums.Gender;
import enums.Role;
import exceptions.AddProductsToStoreException;
import manageroperations.ManagerIntImp;
import models.AsoStore;
import models.Customer;
import models.Staff;

import java.io.IOException;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException, AddProductsToStoreException {

        AsoStore asoStore = new AsoStore("Aso","Edo Tech","Sinebi");
        ManagerIntImp managerIntImp = new ManagerIntImp();
        Staff manager = new Staff("Abc","XYZ","Lagos", Gender.MALE, Role.MANAGER);
        Staff cashier = new Staff("Xzy","xyz","Abuja",Gender.MALE,Role.CASHIER);
        CustomerImp customerImp = new CustomerImp();
        Customer james = new Customer("James","Obi","Lagos",Gender.MALE);
        Customer paul = new Customer("Paul","Innazo","Lagos",Gender.MALE);
        Customer innazo = new Customer("Innazo","Aso","Lagos",Gender.MALE);
        CashierImp cashierImp = new CashierImp();
        customerImp.addMoneyToWallet(james,678880000.78);
        customerImp.addMoneyToWallet(paul,785000.99);
        customerImp.addMoneyToWallet(innazo,677779902.67);

        managerIntImp.addProductsToStore(manager,asoStore);
        //customerImp.addProductToCart(asoStore,"Oraimo Charger",1,paul);
        //customerImp.addProductToCart(asoStore,"iPhone 7",3,james);
        customerImp.addProductToCart(asoStore,"iPhone 7",1,paul);
        customerImp.addProductToCart(asoStore,"iPhone 7",3,james);
        customerImp.addProductToCart(asoStore,"iPhone 7",2,innazo);
        //customerImp.addProductToCart(asoStore,"iPhone 7",1,james);
        customerImp.viewProductByCategory(james,"iPhone",asoStore);



        customerImp.joinQueue(paul,asoStore);
        customerImp.joinQueue(james,asoStore);
        customerImp.joinQueue(innazo,asoStore);
        //customerImp.joinQueue(paul,asoStore);
        cashierImp.checkOutCustomer(cashier,james,asoStore);



    }
}
