package models;

import common.User;
import cashieroperations.CustomerCashierInterface;
import enums.Gender;

public class Customer extends User implements CustomerCashierInterface {

    private Cart myCart;
    private double cartTotal;
    private double walletBalance;

    public Customer(String personName, String personLastName, String personAddress, Gender gender) {
        super(personName, personLastName, personAddress, gender);
        this.myCart = new Cart();
        this.walletBalance = 0.00;
    }


    public Cart getMyCart(){
        return  myCart;
    }
    public double getCartTotal(){

        return cartTotal;
    }

    public void setCartTotal(double amount){
        this.cartTotal+=amount;
    }

    public double getWalletBalance(){

        return walletBalance;
    }

    public void setWalletBalance(double amount){
        this.walletBalance+=amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("myCart=").append(myCart);
        sb.append(", cartTotal=").append(cartTotal);
        sb.append(", product=").append(myCart.getProductName());
        sb.append(", product Unit=").append(myCart.getProductQuantity());
        sb.append(", walletBalance=").append(walletBalance);
        sb.append('}');
        return sb.toString();
    }
}
