package com.github.sats17;

import com.github.sats17.models.h2.Auction;
import com.github.sats17.models.h2.AuctionUser;
import com.github.sats17.models.h2.Item;
import com.github.sats17.repository.h2.AuctionRepository;
import com.github.sats17.repository.h2.AuctionUserRepository;
import com.github.sats17.repository.h2.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;


@SpringBootApplication
public class JavaSqlAssignmentsApplication {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AuctionUserRepository auctionUserRepository;

    @Autowired
    AuctionRepository auctionRepository;

    public static void main(String[] args) {

        SpringApplication.run(JavaSqlAssignmentsApplication.class, args);
    }

    @PostConstruct
    public void ingestData() {

        System.out.println("Ingesting user data");
        for(int i = 0; i < 10; i++) {
            AuctionUser user = new AuctionUser();
            user.setName("user_"+i);
            user.setRole("user");
            auctionUserRepository.save(user);
        }
        auctionUserRepository.findAll().forEach(user -> System.out.println(user.getUserId()));

        for(int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setName("item_"+i);
            item.setStartingPrice((long)10+i);
            item.setCurrentPrice((long)10+i);
            itemRepository.save(item);
        }
        itemRepository.findAll().forEach(item -> System.out.println(item.getItemId()));

        Auction auction = new Auction();
        Instant now = Instant.now();

        // Calculate the time 15 minutes before and after the current time
        Instant minus15Min = now.minus(Duration.ofMinutes(15));
        Instant plus15Min = now.plus(Duration.ofMinutes(15));
        auction.setStartTime(minus15Min.getEpochSecond());
        auction.setEndTime(plus15Min.getEpochSecond());

        Item item = itemRepository.findById(3L).get();

        auction.setItem(item);

        auctionRepository.save(auction);

    }

}