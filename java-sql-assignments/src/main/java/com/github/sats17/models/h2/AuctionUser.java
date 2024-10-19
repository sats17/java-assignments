package com.github.sats17.models.h2;

import jakarta.persistence.*;
import java.util.List;


@Entity(name =  "AUCTION_USER")
public class AuctionUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "user_id")
    private Long userId;

    private String name;

    private String role;

    @OneToMany(mappedBy = "auctionUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bid> bids;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
