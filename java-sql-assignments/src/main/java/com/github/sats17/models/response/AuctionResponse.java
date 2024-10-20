package com.github.sats17.models.response;

import com.github.sats17.models.h2.Item;
import jakarta.persistence.*;

import java.util.List;

public class AuctionResponse {

    private Long auctionId;

    private Long startTime;

    private Long endTime;

    private List<ItemResponse> items;


    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }
}
