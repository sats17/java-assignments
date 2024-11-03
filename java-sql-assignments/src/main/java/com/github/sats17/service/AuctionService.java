package com.github.sats17.service;

import com.github.sats17.models.h2.Auction;
import com.github.sats17.models.h2.AuctionUser;
import com.github.sats17.models.h2.Bid;
import com.github.sats17.models.response.AuctionResponse;
import com.github.sats17.models.response.BidResponse;
import com.github.sats17.models.response.ItemResponse;
import com.github.sats17.repository.h2.AuctionRepository;
import com.github.sats17.repository.h2.AuctionUserRepository;
import com.github.sats17.repository.h2.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    AuctionUserRepository auctionUserRepository;

    public List<AuctionResponse> getAuctionList() {
        List<Auction> auctions =  auctionRepository.findAll();
        return auctions.stream().map( auction -> {
            return new AuctionResponse(
                    auction.getAuctionId(),
                    auction.getStartTime(),
                    auction.getEndTime(),
                    new ItemResponse(auction.getItem().getItemId(), auction.getItem().getName(), auction.getItem().getStartingPrice()),
                    auction.getAuctionUsers().stream().map(AuctionUser::getUserId).collect(Collectors.toSet()),
                    auction.getBids().stream().map(bid -> new BidResponse(bid.getBidId(), bid.getAmount(), bid.getAuctionUser().getUserId(), bid.getAuction().getAuctionId())).toList()
            );
        }).toList();
    }


    public boolean addUserToAuction(Long auctionId, Long userId) {

        Optional<Auction> auctionOpt = auctionRepository.findById(auctionId);
        Optional<AuctionUser> userOpt = auctionUserRepository.findById(userId);

        if (auctionOpt.isPresent() && userOpt.isPresent()) {
            Auction auction = auctionOpt.get();
            AuctionUser user = userOpt.get();

            if(auction.getAuctionUsers().contains(user)) {
                return false;
            }

            auction.getAuctionUsers().add(user);

            auctionRepository.save(auction);

            return true;
        }
        return false;
    }

    //  TODO: Transactional
    public boolean createBid(Long userId, Long auctionId, Long itemId, Long amount) {
        Auction auction = auctionRepository.findById(auctionId).get();
        AuctionUser user = auctionUserRepository.findById(userId).get();

        if(!auction.getAuctionUsers().contains(user)) {
            return false;
        }

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
