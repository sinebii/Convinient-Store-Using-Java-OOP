package customeroperations;

import models.AsoStore;
import models.Customer;
import models.Product;

public class CustomerImp implements CustomerInt{

    @Override
    public void addProductToCart(AsoStore asoStore,String productName, int quantity, Customer customer){
        for(Product each: asoStore.getListofProducts()){
            if(each.getProductName().equalsIgnoreCase(productName)){
                    if(each.getProductQuantity()>=quantity){
                        customer.getCart().put(each,quantity);
                        cartTotal(customer);
                    }else if(each.getProductQuantity()<quantity && each.getProductQuantity() >0){
                        System.out.println("Product May be out of Stock");
                        break;
                    }else{

                        System.out.println("Product out of Stock");
                        break;
                    }
                }
            }
        }
        //customer.getCart().put(product,quantity);

//    public void removeProductFromCart(String productName,Customer customer){
//
//    }

    public void cartTotal(Customer customer){
         double total =0.00;
        for(Product each:customer.getCart().keySet()){
            int cartQuantity = customer.getCart().get(each);
            total +=each.getProductPrice()*cartQuantity;
        }
        customer.setCartTotal(total);

    }


    public void addMoneyToWallet(Customer customer, double amount){
        customer.setWalletBalance(amount);
    }
}
