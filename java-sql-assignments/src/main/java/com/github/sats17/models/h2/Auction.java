package com.github.sats17.models.h2;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id")
    private Long auctionId;

    // Many to one itemId
    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @OneToOne
    @JoinColumn(name = "item_id")  // Foreign key to reference the item
    private Item item;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bid> bids;

    @ManyToMany(targetEntity = AuctionUser.class)
    @JoinTable(name = "auction_users",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<AuctionUser> auctionUsers;


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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Set<AuctionUser> getAuctionUsers() {
        return auctionUsers;
    }

    public void setAuctionUsers(Set<AuctionUser> auctionUsers) {
        this.auctionUsers = auctionUsers;
    }
}
