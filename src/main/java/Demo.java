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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

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
        Customer daniel = new Customer("Daniel","James","Lagos",Gender.MALE);
        Customer uche = new Customer("Uche","Olelewe","Lagos",Gender.MALE);
        CashierImp cashierImp = new CashierImp();
        customerImp.addMoneyToWallet(james,678880000.78);
        customerImp.addMoneyToWallet(paul,780005000.99);
        customerImp.addMoneyToWallet(innazo,677779902.67);
        customerImp.addMoneyToWallet(daniel,677779902.67);
        customerImp.addMoneyToWallet(uche,677779902.67);


        managerIntImp.addProductsToStore(manager,asoStore);
        customerImp.addProductToCart(asoStore,"iPhone 7",6,paul);
        customerImp.addProductToCart(asoStore,"iPhone 7",6,james);
        customerImp.addProductToCart(asoStore,"iPhone 7",3,innazo);
        customerImp.addProductToCart(asoStore,"Oraimo Charger",5,daniel);


        Callable<String> callable = cashierImp.checkOutCustomer(cashier,james,asoStore);
        Callable<String> callable1 = cashierImp.checkOutCustomer(cashier,paul,asoStore);
        Callable<String> callable2 = cashierImp.checkOutCustomer(cashier,innazo,asoStore);
        Callable<String> callable3 = cashierImp.checkOutCustomer(cashier,daniel,asoStore);
        //Callable<String> callable4 = cashierImp.checkOutCustomer(cashier,uche,asoStore);

        Set<Callable<String>> callableSet = new HashSet<>();

        callableSet.add(callable);
        callableSet.add(callable1);
        callableSet.add(callable2);
        callableSet.add(callable3);
        //callableSet.add(callable4);

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            List<Future<String>> futures = executor.invokeAll(callableSet);
            for(Future<String> future : futures){
                System.out.println(future.get());
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }finally {
            System.out.println(Arrays.toString(asoStore.getListofProducts()));
            executor.shutdown();
        }



    }
}
