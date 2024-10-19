package com.github.sats17.models.h2;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;
    private String name;

    @Column(name = "starting_price")
    private Long startingPrice;

    @Column(name = "current_price")
    private Long currentPrice;

//    @OneToOne(mappedBy = "item", optional = true)
//    private Auction auction;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Long startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }

    //    public Auction getAuction() {
//        return auction;
//    }
//
//    public void setAuction(Auction auction) {
//        this.auction = auction;
//    }
}
