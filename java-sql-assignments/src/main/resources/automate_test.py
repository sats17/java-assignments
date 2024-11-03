import requests
import threading
import random
import time

# Set your API base URL here
API_BASE_URL = "http://localhost:8082/api/auction"
AUCTION_ID = 1  # Specify the auction ID to use
MAX_USERS = 5 # Number of users
BID_COUNT_PER_USER = 10  # Number of bids each user will make

# Define user IDs and item IDs for bidding
user_ids = range(1, MAX_USERS + 1)  # User IDs from 1 to MAX_USERS
item_ids = [1]  # Sample item IDs, adjust according to your data

# Adding users to the auction
def add_user_to_auction(user_id):
    url = f"{API_BASE_URL}/{AUCTION_ID}/user"
    payload = {"userId": user_id}
    response = requests.post(url, json=payload)
    print(f"Add User Response for User {user_id}: {response.status_code} - {response.text}")

# Function for each user to place random bids
def place_random_bids(user_id):
    url = f"{API_BASE_URL}/{AUCTION_ID}/bid"
    for _ in range(BID_COUNT_PER_USER):
        bid_request = {
            "userId": user_id,
            "itemId": random.choice(item_ids),
            "amount": random.uniform(10, 500)  # Random bid amount between 10 and 500
        }
        print(bid_request)
        response = requests.post(url, json=bid_request)
        print(f"Bid Response for User {user_id}: Status {response.status_code}, Response: {response.text}")
        time.sleep(random.uniform(0.5, 2.0))  # Random delay between 0.5 to 2 seconds between bids

# Step 1: Add users to the auction
for user_id in user_ids:
    add_user_to_auction(user_id)

# Step 2: Start bidding threads for each user
threads = []
for user_id in user_ids:
    thread = threading.Thread(target=place_random_bids, args=(user_id,))
    threads.append(thread)
    thread.start()

# Step 3: Wait for all threads to finish
for thread in threads:
    thread.join()

print("Bidding simulation complete.")
