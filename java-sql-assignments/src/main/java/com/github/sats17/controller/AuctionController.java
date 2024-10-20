package com.github.sats17.controller;

import com.github.sats17.models.h2.Auction;
import com.github.sats17.models.h2.Bid;
import com.github.sats17.models.request.BidRequest;
import com.github.sats17.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @GetMapping
    public List<Auction> getAuctions() {
        return auctionService.getAuctionList();
    }

    @GetMapping("/{auctionId}")
    public List<Auction> getAuctionByAuctionId(@PathVariable Long auctionId) {
        return auctionService.getAuctionList();
    }

    @PostMapping("/{auctionId}/bid")
    public ResponseEntity<String> createBid(
            @PathVariable Long auctionId,
            @RequestBody BidRequest bid) {

        boolean response = auctionService.createBid(bid.getUserId(), auctionId, bid.getItemId(), bid.getAmount());
        if(response) {
            return new ResponseEntity<>("Bid created", HttpStatusCode.valueOf(200));
        } else {
            return new ResponseEntity<>("Bid creation failed", HttpStatusCode.valueOf(500));
        }
    }

}
