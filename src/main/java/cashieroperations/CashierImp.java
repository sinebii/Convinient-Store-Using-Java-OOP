package cashieroperations;
import enums.Role;
import exceptions.CashierAuthorization;
import exceptions.CustomerEmptyCartException;
import exceptions.CustomerInsufficientFunds;
import exceptions.OutOfStockException;
import models.AsoStore;
import models.Customer;
import models.Product;
import models.Staff;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;

public class CashierImp implements CashierInt, CustomerCashierInterface {

    private String message = "";
    public Callable<String> checkOutCustomer(Staff staff, Customer customer, AsoStore asoStore) {
        try{
            if(staff.getRole().equals(Role.MANAGER)) throw new CashierAuthorization("Reserved for Cashiers only");
            if(customer.cartTotal(customer,asoStore)>customer.getWalletBalance()) throw new CustomerInsufficientFunds("Insufficient Balance in your wallet");
            if(customer.getMyCart().getProductName()==null) throw new CustomerEmptyCartException("Dear "+customer.getPersonName()+", Your cart is empty");
            sellProduct(customer, asoStore);

            //return ()-> Thread.currentThread().getName();
            System.out.println(Thread.currentThread().getName());

        }catch (CashierAuthorization | CustomerInsufficientFunds | IOException | OutOfStockException | CustomerEmptyCartException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return ()-> Thread.currentThread().getName()+ ": " + customer.getPersonName();
    }

    private void sellProduct(Customer customer, AsoStore asoStore) throws IOException {
        message = "";
        message+="Thanks for Patronizing us\n" +
                "Transaction Details\n"+
                "***********************\n";
        for(Product each:asoStore.getListofProducts()){
            if(each.getProductName().equals(customer.getMyCart().getProductName())){

                if(each.getProductQuantity() < customer.getMyCart().getProductQuantity()) throw new OutOfStockException(each.getProductName()+ " is out of stock");
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
        Random rand = new Random();
        String now = String.valueOf(rand.nextInt(100000));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/cashieroperations/Receipt"+now+".txt"));
        bw.write(message);
        bw.close();

    }
}
