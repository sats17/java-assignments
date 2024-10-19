package com.github.sats17.repository.h2;

import com.github.sats17.models.h2.Auction;
import com.github.sats17.models.h2.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    @Query("SELECT MAX(b.amount) FROM Bid b WHERE b.auction.auctionId = :auctionId")
    Long findMaxAmountByAuctionId(@Param("auctionId") Long auctionId);
}
