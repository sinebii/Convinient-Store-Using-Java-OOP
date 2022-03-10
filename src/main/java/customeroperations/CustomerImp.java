package customeroperations;
import exceptions.OutOfStockException;
import models.AsoStore;
import models.Customer;
import models.Product;

public class CustomerImp implements CustomerInt{

    @Override

    public void addProductToCart(AsoStore asoStore,String productName, int quantity, Customer customer){
        try{
            for(Product each: asoStore.getListofProducts()){
                if(each.getProductName().equalsIgnoreCase(productName)){
                    if(each.getProductQuantity()>=quantity) {
                        if (productName.equals(customer.getMyCart().getProductName())) {
                            customer.getMyCart().setProductQuantity(customer.getMyCart().getProductQuantity() + quantity);
                            if (customer.getMyCart().getProductQuantity() > each.getProductQuantity())
                                throw new OutOfStockException("Out stock Exception");
                        } else {

                            customer.getMyCart().setProductName(each.getProductName());
                            customer.getMyCart().setProductQuantity(quantity);
                        }

                    }

                }
            }
        }catch (OutOfStockException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        }


    public void addMoneyToWallet(Customer customer, double amount){
        customer.setWalletBalance(amount);
    }

    public void viewProductByCategory(Customer customer,String category, AsoStore asoStore){

        for(Product each: asoStore.getListofProducts()){
            if(each.getProductCategory().equals(category)){
                System.out.println("Product Name: "+each.getProductName());
                System.out.println("Product Price: "+each.getProductPrice());
                System.out.println("Product Category: "+each.getProductCategory());
                System.out.println("------------------");
            }
        }
    }

    public Object clearCart(Customer customer){
        customer.getMyCart().setProductQuantity(0);
        customer.getMyCart().setProductName(null);
        return null;
    }

}
