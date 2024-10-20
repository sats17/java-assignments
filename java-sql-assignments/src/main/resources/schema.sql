CREATE TABLE auction_user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE item (
    item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    starting_price BIGINT NOT NULL
);

CREATE TABLE auction (
    auction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_time BIGINT NOT NULL,
    end_time BIGINT NOT NULL,
    item_id BIGINT NOT NULL,  -- Added item_id column for foreign key
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE bid (
    bid_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    amount BIGINT NOT NULL,
    auction_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES auction_user(user_id),
    FOREIGN KEY (auction_id) REFERENCES auction(auction_id)
);
