package com.github.sats17.basicassignment.solidprinciple.interfacesaggregation;


/**
 * @author sats17
 * 
 * In this class we are seggregating the interfaces into two interfaces. This is called interface segregation.
 * We are segregating the interfaces because we want to provide only the functionality which is contractually applied to the particular interface.
 * So, we can provide that only contract to client. 
 * 
 * Read Customer.java and Worker.java for more details.
 */
public class Shop implements ShopRead, ShopWrite{

    @Override
    public String addItem() {
        return "We are adding new item";
    }

    @Override
    public String getItems() {
        return "We are getting all items";
    }
    
}
