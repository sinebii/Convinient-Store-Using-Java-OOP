package models;

import common.User;
import enums.Gender;

import java.util.HashMap;

public class Customer extends User {

    private HashMap<Product,Integer>cart;
    private double cartTotal;
    private double walletBalance;
    public Customer() {
    }

    public Customer(String personName, String personLastName, String personAddress, Gender gender) {
        super(personName, personLastName, personAddress, gender);
        this.cart = new HashMap<>();
        this.cartTotal = cartTotal;
        this.walletBalance = 0.00;
    }


    public HashMap<Product, Integer> getCart() {
        return cart;
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


}
