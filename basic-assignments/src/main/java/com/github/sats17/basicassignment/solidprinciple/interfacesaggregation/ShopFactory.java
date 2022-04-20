package com.github.sats17.basicassignment.solidprinciple.interfacesaggregation;

/**
 * @author sats17
 * 
 * Factory class to create ShopRead and ShopWrite objects
 */
public class ShopFactory {
    
    public static ShopRead getShopRead() {
        return new Shop();
    }
    
    public static ShopWrite getShopWrite() {
        return new Shop();
    }

}
