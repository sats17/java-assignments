package com.github.sats17.models.response;

public class BidResponse {

    private Long bidId;
    private Long amount;
    private Long auctionUserId;
    private Long auctionId;

    public BidResponse(Long bidId, Long amount, Long auctionUserId, Long auctionId) {
        this.bidId = bidId;
        this.amount = amount;
        this.auctionUserId = auctionUserId;
        this.auctionId = auctionId;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAuctionUserId() {
        return auctionUserId;
    }

    public void setAuctionUserId(Long auctionUserId) {
        this.auctionUserId = auctionUserId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }
}
