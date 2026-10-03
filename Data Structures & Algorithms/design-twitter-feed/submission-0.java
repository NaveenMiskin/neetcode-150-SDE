class Twitter {

    class Tweet {
        int tweetId;
        int time;
        int userId;

        public Tweet(int tweetId, int time, int userId) {
            this.tweetId = tweetId;
            this.time = time;
            this.userId = userId;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(
            new Tweet(tweetId, time++, userId)
        );
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Add user's own latest tweet
        addLatestTweet(userId, pq);

        // Add latest tweet of every followee
        if (followMap.containsKey(userId)) {

            for (int followee : followMap.get(userId)) {
                addLatestTweet(followee, pq);
            }
        }

        // Get 10 most recent tweets
        while (!pq.isEmpty() && result.size() < 10) {

            Tweet current = pq.poll();

            result.add(current.tweetId);

            // Get previous tweet of the same user
            List<Tweet> tweets = tweetMap.get(current.userId);

            int index = tweets.size() - 1;

            // Find the position of current tweet
            while (index >= 0 && tweets.get(index) != current) {
                index--;
            }

            // Add previous tweet to heap
            if (index > 0) {
                pq.offer(tweets.get(index - 1));
            }
        }

        return result;
    }

    private void addLatestTweet(int userId, PriorityQueue<Tweet> pq) {

        if (tweetMap.containsKey(userId)) {

            List<Tweet> tweets = tweetMap.get(userId);

            if (!tweets.isEmpty()) {
                pq.offer(tweets.get(tweets.size() - 1));
            }
        }
    }

    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
