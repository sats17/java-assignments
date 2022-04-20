package com.github.sats17.basicassignment.solidprinciple.interfacesaggregation;

public class Customer {
    public static void main(String[] args) {

        // By returning the object of ShopRead interface, we are able to access only those method which are 
        // defined in ShopRead interface. This is a example of interface as a code.
        ShopRead shopRead = ShopFactory.getShopRead();
        System.out.println(shopRead.getItems());

        // Below code will throw compile erro, as we are trying to access ShopWrite interface
        // System.out.println(shopRead.addItems());
    }
}
