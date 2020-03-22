package medium.leetcode355;

import java.util.*;

/**
 * 设计推特:
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 *
 * 示例:
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
  *
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

/**
 * 哈希表 + 大顶堆：
 * 1、用一个哈希表维护每个用户发过的推特，当postTweet时，更新这个哈希表
 * 2、再用一个哈希表维护每个用户关注的人，当follow或unFollow时，更新这个哈希表
 * 3、每一个推特都有一个时间戳，发布时间越近，值越大，当getNewsFeed时，把用户发过的推特和关注人发过的推特放入一个大顶堆中，最后取大顶堆前10篇推特即返回结果
 */
public class Twitter {

    private static final int COUNT = 10;
    private HashMap<Integer, Set<Integer>> followers = new HashMap<>();
    private HashMap<Integer, List<Tweet>> tweets = new HashMap<>();
    private Queue<Tweet> newsFeed = new PriorityQueue<>(COUNT, new Comparator<Tweet>() {
        @Override
        public int compare(Tweet o1, Tweet o2) {
            return Integer.compare(o2.postTime, o1.postTime);
        }
    });
    private int postTime = 0;//时间戳

    /** Initialize your data structure here. */
    public Twitter() {}

    /**
     * userId 发表id为 tweetId 的Tweet
     */
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new LinkedList<>());
        List<Tweet> postTweets = tweets.get(userId);
        Tweet tweet = new Tweet(tweetId, ++postTime);
        postTweets.add(tweet);
    }

    /**
     * followerId 关注 followeeId
     */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followers.computeIfAbsent(followerId, k -> new HashSet<>());
        Set<Integer> followees = followers.get(followerId);
        followees.add(followeeId);
    }

    /**
     * followerId 取消关注 followeeId
     */
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            Set<Integer> followees = followers.get(followerId);
            followees.remove(followeeId);
            if(followees.isEmpty()){
                followers.remove(followerId);
            }
        }
    }


    /**
     * userId 获取关注人和自己的最近十条Tweet的tweetId
     */
    public List<Integer> getNewsFeed(int userId) {
        newsFeed.clear();
        //获取自己发布的文章
        if(tweets.containsKey(userId)){
            List<Tweet> postTweets = tweets.get(userId);
            addToNewsFeed(postTweets);
        }
        //获取关注人发布的文章
        if(followers.containsKey(userId)){
            Set<Integer> followees = followers.get(userId);
            for(Integer followeeId : followees){
                List<Tweet> followeePostTweets = tweets.get(followeeId);
                if(followeePostTweets != null){
                    addToNewsFeed(followeePostTweets);
                }
            }
        }
        //返回结果
        LinkedList<Integer> ret = new LinkedList<>();
        while (!newsFeed.isEmpty() && ret.size() < 10){
            Tweet tweet = newsFeed.poll();
            ret.add(tweet.id);
        }
        return ret;
    }

    /**
     * 维护一个大顶堆，越靠近堆顶，Tweet发布时间最近
     */
    private void addToNewsFeed(List<Tweet> tweets){
        for(Tweet tweet : tweets){
            newsFeed.add(tweet);
        }
    }


    class Tweet{

        int id;
        int postTime;

        Tweet(int id, int time){
            this.id = id;
            this.postTime = time;
        }
    }

}
