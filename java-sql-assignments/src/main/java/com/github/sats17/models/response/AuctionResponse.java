package com.github.sats17.models.response;

import com.github.sats17.models.h2.Item;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

public class AuctionResponse {

    private Long auctionId;

    private Long startTime;

    private Long endTime;

    private ItemResponse item;

    private Set<Long> userId;

    private List<BidResponse> bids;

    public AuctionResponse(Long auctionId, Long startTime, Long endTime, ItemResponse item, Set<Long> userId, List<BidResponse> bids) {
        this.auctionId = auctionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.item = item;
        this.userId = userId;
        this.bids = bids;
    }

    public Set<Long> getUserId() {
        return userId;
    }

    public void setUserId(Set<Long> userId) {
        this.userId = userId;
    }

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

    public ItemResponse getItem() {
        return item;
    }

    public void setItem(ItemResponse item) {
        this.item = item;
    }

    public List<BidResponse> getBids() {
        return bids;
    }

    public void setBids(List<BidResponse> bids) {
        this.bids = bids;
    }
}
