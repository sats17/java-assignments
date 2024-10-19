package com.github.sats17.service;

import com.github.sats17.models.h2.Auction;
import com.github.sats17.models.h2.AuctionUser;
import com.github.sats17.models.h2.Bid;
import com.github.sats17.repository.h2.AuctionRepository;
import com.github.sats17.repository.h2.AuctionUserRepository;
import com.github.sats17.repository.h2.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    AuctionUserRepository auctionUserRepository;

    public List<Auction> getAuctionList() {
        return auctionRepository.findAll();
    }

    public boolean createBid(Long userId, Long auctionId, Long itemId, Long amount) {
        Auction auction = auctionRepository.findById(auctionId).get();
        AuctionUser user = auctionUserRepository.findById(userId).get();

        Long currentAmount = bidRepository.findMaxAmountByAuctionId(auctionId);


        if (currentAmount != null && amount <= currentAmount) {
            System.out.println("Bid cannot place due to amount is same. User ID " + userId);
            return false;
        }

        Bid bid = new Bid();
        bid.setAmount(amount);
        bid.setAuction(auction);
        bid.setAuctionUser(user);


        bidRepository.save(bid);

        return true;
    }

}
