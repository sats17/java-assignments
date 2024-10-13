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
    end_time BIGINT NOT NULL
);

CREATE TABLE bid (
    bid_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES auction_user(user_id)
);
