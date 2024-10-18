package com.github.sats17.repository.h2;

import com.github.sats17.models.h2.AuctionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionUserRepository extends JpaRepository<AuctionUser, Long> {
}
