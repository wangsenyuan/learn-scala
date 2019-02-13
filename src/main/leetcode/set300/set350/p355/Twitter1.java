package set300.set350.p355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by wangsenyuan on 6/11/16.
 */
public class Twitter1 {

    private Map<Integer, Set<Integer>> users = new HashMap<>();
    private Map<Integer, Map<Integer, Integer>> tweets = new HashMap<>();
    private int timeStamp = 0;

    public Twitter1() {

    }

    public void postTweet(int userId, int tweetId) {
        if (users.get(userId) == null) {
            users.put(userId, new HashSet<>());
            tweets.put(userId, new HashMap<>());
        }
        tweets.get(userId).put(timeStamp++, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (users.get(userId) == null)
            return res;
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getKey() - e1.getKey());
        for (Map.Entry<Integer, Integer> e : tweets.get(userId).entrySet())
            queue.offer(e);
        for (Integer user : users.get(userId)) {
            for (Map.Entry<Integer, Integer> e : tweets.get(user).entrySet()) {
                queue.offer(e);
            }
        }
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            res.add(queue.poll().getValue());
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (users.get(followerId) == null) {
            users.put(followerId, new HashSet<>());
            tweets.put(followerId, new HashMap<>());
        }
        if (users.get(followeeId) == null) {
            users.put(followeeId, new HashSet<>());
            tweets.put(followeeId, new HashMap<>());
        }
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (users.get(followerId) == null || users.get(followeeId) == null)
            return;
        users.get(followerId).remove(followeeId);
    }
}
