package com.github.sats17.models.response;

import jakarta.persistence.Column;

public class ItemResponse {

    private Long itemId;
    private String name;
    private Long startingPrice;

    public ItemResponse(Long itemId, String name, Long startingPrice) {
        this.itemId = itemId;
        this.name = name;
        this.startingPrice = startingPrice;
    }

    public Long getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Long startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
