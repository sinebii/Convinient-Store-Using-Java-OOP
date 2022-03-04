package cashieroperations;

import enums.Role;
import exceptions.CashierAuthorization;
import exceptions.CustomerInsufficientFunds;
import models.AsoStore;
import models.Customer;
import models.Product;
import models.Staff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class CashierImp implements CashierInt, CustomerCashierInterface {

    private String message = "";

    public void checkOutCustomer(Staff staff,Customer customer,AsoStore asoStore) throws IOException {
        if(staff.getRole().equals(Role.MANAGER)) throw  new CashierAuthorization("Operation Reserved for Cashiers only");
        if(customer.cartTotal(customer,asoStore)>customer.getWalletBalance()) throw new CustomerInsufficientFunds("Insufficient Funds in your Wallet");
    //if(customer.cartTotal(customer,asoStore)> customer.getWalletBalance()) throw new CustomerInsufficientFunds("Not enough funds in Waller");

        while(!asoStore.getCustomerQueue().isEmpty()){
            Customer custo = asoStore.getCustomerQueue().poll();
            sellProduct(custo,asoStore);
        }
    }

    private void sellProduct(Customer customer, AsoStore asoStore) throws IOException {
        message = "";

        message+="Thanks for Patronizing us\n" +
                "Transaction Details\n";
        for(Product each:asoStore.getListofProducts()){
            if(each.getProductName().equals(customer.getMyCart().getProductName())){
                message+="Product Name:"+each.getProductName()+"\n" +
                        "Product Category:"+each.getProductCategory()+"\n" +
                        "Product Unit: "+customer.getMyCart().getProductQuantity()+"\n" +
                        "Product Cost:"+customer.getMyCart().getProductQuantity()* each.getProductPrice()+"\n";

                double price = customer.getMyCart().getProductQuantity()* each.getProductPrice();

                each.setProductQuantity(each.getProductQuantity()-customer.getMyCart().getProductQuantity());
                customer.getMyCart().setProductName(null);
                customer.getMyCart().setProductQuantity(0);

                customer.setWalletBalance(customer.getWalletBalance() - price);
                generateReceipt();

            }
        }

    }

    private void generateReceipt() throws IOException {
        Date now = new Date();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/cashieroperations/Receipt"+(now.toInstant())+".txt"));
        bw.write(message);
        bw.close();

    }
}
