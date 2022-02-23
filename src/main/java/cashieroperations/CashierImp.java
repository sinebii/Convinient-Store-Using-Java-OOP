package cashieroperations;

import enums.Role;
import exceptions.CashierAuthorization;
import exceptions.DeclinedTransaction;
import models.AsoStore;
import models.Customer;
import models.Product;
import models.Staff;

import java.util.Map;

public class CashierImp implements CashierInt{

    public void checkOutCustomer(Staff staff, Customer customer, AsoStore asoStore){

        if(staff.getRole().equals(Role.CASHIER)){
            if(customer.getCartTotal() <= customer.getWalletBalance()){
                for(Map.Entry<Product, Integer> each : customer.getCart().entrySet()){
                        String productName = each.getKey().getProductName();
                        int quantityOfCustomer = each.getValue();
                        for (Product entry : asoStore.getListofProducts()) {
                            if (entry.getProductName().equals(productName)) {
                                entry.setProductQuantity(entry.getProductQuantity()-quantityOfCustomer);
                            }
                        }
                }
            }else{

                throw new DeclinedTransaction("Transaction Declined, Your wallet balance is insufficient");
            }
        }else{

            throw new CashierAuthorization("Only Cashiers are allowed to carry out this Operation");
        }



    }

    public void generateReceipt(Staff staff,Customer customer,AsoStore asoStore){

        System.out.println("****** Asostore Convenient Store*****");
        System.out.println("Your Satisfaction is our top priority");
        System.out.println("Sales Receipt");
        System.out.println("--------------");
        System.out.println("Cashier Name: "+ staff.getPersonName()+ " "+staff.getPersonLastName());
        System.out.println("---------------------------------------");

        for (Map.Entry<Product, Integer> inCart:customer.getCart().entrySet()){

            System.out.println("Product Name: "+inCart.getKey().getProductName());
            System.out.println("Product Category: "+inCart.getKey().getProductCategory());
            System.out.println("Product Price: "+inCart.getKey().getProductPrice());
            System.out.println("Quantity: "+inCart.getValue());
            System.out.println("-----------------------------------");

        }
        System.out.println("Total cost of goods: "+customer.getCartTotal());

    }
}
