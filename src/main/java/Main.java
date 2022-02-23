import application.ApplicationImplementation;
//import cashieroperations.CashierImp;
import cashieroperations.CashierImp;
import customeroperations.CustomerImp;
import enums.Gender;
import enums.Qualification;
import enums.Role;
import exceptions.applicantExistException;
//import manageroperations.ManagerOperationsImp;
import models.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws applicantExistException, IOException {

        AsoStore asoStore = new AsoStore("Aso Store","Edo Tech Park","Decagon");
        ApplicationImplementation application = new ApplicationImplementation();
        Applicant sinebi = new Applicant("Sinebi","Innazo","Ikoyi", Gender.MALE,24, Qualification.MSC, Role.CASHIER);
        Applicant chisom = new Applicant("Chisom","Dike","Edo",Gender.FEMALE,30,Qualification.BSC,Role.CASHIER);

        Staff innocent = new Staff("Innocent","Idibia","Ikoyi Lagos",Gender.MALE,Role.MANAGER);

        //application.apply(sinebi,asoStore);
        //application.apply(chisom,asoStore);
        //System.out.println(asoStore.getListOfApplicants());
        //RecruitmentImplementation newRecruitment = new RecruitmentImplementation();
        //newRecruitment.hireCashier(sinebi,innocent,asoStore);
        //System.out.println(asoStore.getListOfApplicants());
        Product shoe = new Product("Nike Snickers","Fashion",34500.67,0);
        Product bag = new Product("Gucci","Fashion",23500.67,0);

        Customer james = new Customer("James","Idoko","Ikeja",Gender.MALE);

//        ManagerOperationsImp mgroperations = new ManagerOperationsImp();
//        mgroperations.addProductToStore(shoe,15, innocent,asoStore);
//        mgroperations.addProductToStore(bag,23,innocent,asoStore);
//        System.out.println("List of Products"+asoStore.getListofProducts());
        //System.out.println("Old product Qty"+Arrays.toString(asoStore.getListofProducts()));
        CustomerImp customerOps = new CustomerImp();
        customerOps.addProductToCart(asoStore,"Samsung S9",1,james);
        customerOps.addProductToCart(asoStore,"Oraimo Charger",3,james);
        customerOps.addProductToCart(asoStore,"Tecno Ms",20,james);
        //System.out.println("Cart for james :"+james.getCart());
        //customerOps.removeProductFromCart("Oraimo Charger",james);

        //customerOps.cartTotal(james);
        //System.out.println("Product for james :"+james.getCart());
        //System.out.println("TOTAL AMOUNT IN CART :"+james.getCartTotal());
        customerOps.addMoneyToWallet(james,20800000.80);
        //System.out.println("James new cart after removing Oraimo"+james.getCart());



       Staff abc = new Staff("Deen","Lawal","Abuja",Gender.MALE,Role.CASHIER);
       CashierImp cashier = new CashierImp();
       cashier.checkOutCustomer(abc,james,asoStore);
       cashier.generateReceipt(abc,james,asoStore);
<<<<<<< HEAD
=======
       customerOps.viewAllProducts(asoStore,james);
>>>>>>> f45fa48 (My Week_two first upload)
//        System.out.println("List of Product "+asoStore.getListofProducts());

        //System.out.println("New Product Qty "+Arrays.toString(asoStore.getListofProducts()));

    }
}
