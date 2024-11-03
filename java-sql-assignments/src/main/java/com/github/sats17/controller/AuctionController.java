package com.github.sats17.controller;

import com.github.sats17.models.request.AddUserToAuctionRequest;
import com.github.sats17.models.request.BidRequest;
import com.github.sats17.models.response.AuctionResponse;
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
    public List<AuctionResponse> getAuctions() {
        return auctionService.getAuctionList();
    }

    @GetMapping("/{auctionId}")
    public List<AuctionResponse> getAuctionByAuctionId(@PathVariable Long auctionId) {
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

    @PostMapping("/{auctionId}/user")
    public ResponseEntity<String> addUserToAuction(
            @PathVariable Long auctionId,
            @RequestBody AddUserToAuctionRequest request) {

        if(request.getUserId() == null || auctionId == null) {
            return ResponseEntity.badRequest().body("Invalid request.");
        }


        boolean success = auctionService.addUserToAuction(auctionId, request.getUserId());
        if (success) {
            return ResponseEntity.ok("User added to auction successfully.");
        } else {
            return ResponseEntity.internalServerError().body("Failed to add user to auction.");
        }
    }

}
