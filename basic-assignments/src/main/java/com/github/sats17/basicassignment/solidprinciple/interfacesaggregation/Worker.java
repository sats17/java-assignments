package com.github.sats17.basicassignment.solidprinciple.interfacesaggregation;

public class Worker {
    public static void main(String[] args) {

        // By returning the object of ShopRead interface, we are able to access only those method which are 
        // defined in ShopRead interface. This is a example of interface as a code.
        ShopWrite shop = ShopFactory.getShopWrite();
        System.out.println(shop.addItem());

        // Below code will throw compile erro, as we are trying to access ShopRead interface
        // System.out.println(shop.getItems());
    }
}
