//import application.ApplicationImplementation;
////import cashieroperations.CashierImp;
//import cashieroperations.CashierImp;
//import customeroperations.CustomerImp;
//import enums.Gender;
//import enums.Qualification;
//import enums.Role;
//import exceptions.applicantExistException;
////import manageroperations.ManagerOperationsImp;
//import models.*;
//
//import java.io.IOException;
//public class Main {
//    public static void main(String[] args) throws applicantExistException, IOException {
//
//        AsoStore asoStore = new AsoStore("Aso Store","Edo Tech Park","Decagon");
//        ApplicationImplementation application = new ApplicationImplementation();
//        Applicant sinebi = new Applicant("Sinebi","Innazo","Ikoyi", Gender.MALE,24, Qualification.MSC, Role.CASHIER);
//        Applicant chisom = new Applicant("Chisom","Dike","Edo",Gender.FEMALE,30,Qualification.BSC,Role.CASHIER);
//
//        Staff innocent = new Staff("Innocent","Idibia","Ikoyi Lagos",Gender.MALE,Role.MANAGER);
//        Staff obi = new Staff("Obi Emeka","Emeka","Abuja",Gender.MALE,Role.CASHIER);
//
//        //application.apply(sinebi,asoStore);
//        //application.apply(chisom,asoStore);
//        //System.out.println(asoStore.getListOfApplicants());
//        //RecruitmentImplementation newRecruitment = new RecruitmentImplementation();
//        //newRecruitment.hireCashier(sinebi,innocent,asoStore);
//        //System.out.println(asoStore.getListOfApplicants())
//
//        Customer james = new Customer("James","Idoko","Ikeja",Gender.MALE);
//
//
//        CustomerImp customerOps = new CustomerImp();
//        customerOps.addProductToCart(asoStore,"Samsung S9",1,james);
//        customerOps.addProductToCart(asoStore,"Oraimo Charger",3,james);
//        customerOps.addProductToCart(asoStore,"Tecno Ms",5,james);
//        //System.out.println("Cart for james :"+james.getCart());
//        //customerOps.removeProductFromCart("Oraimo Charger",james);
//
//        //customerOps.cartTotal(james);
//        //System.out.println("Product for james :"+james.getCart());
//        //System.out.println("TOTAL AMOUNT IN CART :"+james.getCartTotal());
//        customerOps.addMoneyToWallet(james,2800000.80);
//        //System.out.println("James new cart after removing Oraimo"+james.getCart());
//
//
//        System.out.println(james.getWalletBalance());
//        Staff abc = new Staff("Deen","Lawal","Abuja",Gender.MALE,Role.CASHIER);
//        CashierImp cashier = new CashierImp();
//        cashier.checkOutCustomer(obi,james,asoStore);
//        System.out.println(james.getWalletBalance());
//        customerOps.viewProductByCategory(james,"Apple",asoStore);
//
//    }
//}
