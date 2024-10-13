package com.github.sats17.repository;

import com.github.sats17.models.AuctionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionUserRepository extends JpaRepository<AuctionUser, Long> {
}
