package set0000.set300.set350.p355

import scala.collection.mutable

class Twitter() {
  private var time = 0
  /** Initialize your data structure here. */
  private val tweets = mutable.Map.empty[Int, List[(Int, Int)]].withDefault((_) => List.empty[(Int, Int)])
  private val following = mutable.Map.empty[Int, Set[Int]].withDefault((_) => Set.empty[Int])

  /** Compose a new tweet. */
  def postTweet(userId: Int, tweetId: Int) {
    time += 1
    var ts = tweets(userId)
    if (ts.length == 10) {
      ts = ts.init
    }

    tweets += userId -> ((tweetId, time) :: ts)
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  def getNewsFeed(userId: Int): List[Int] = {

    def merge(a: List[(Int, Int)], b: List[(Int, Int)]): List[(Int, Int)] = {
      (a, b) match {
        case (Nil, _) => b
        case (_, Nil) => a
        case (ah +: at, bh +: bt) =>
          if (ah._2 >= bh._2) {
            ah :: merge(at, b)
          } else {
            bh :: merge(a, bt)
          }
      }
    }

    def go(ls: Array[List[(Int, Int)]]): List[(Int, Int)] = {
      if (ls.isEmpty) {
        Nil
      } else if (ls.size == 1) {
        ls.head
      } else {
        val mid = ls.size / 2
        val (first, second) = ls.splitAt(mid)
        merge(go(first), go(second)).take(10)
      }
    }

    val users = following(userId) + userId

    go(users.map(tweets).toArray).map(_._1)
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  def follow(followerId: Int, followeeId: Int) {
    following(followerId) += followeeId
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  def unfollow(followerId: Int, followeeId: Int) {
    following(followerId) -= followeeId
  }

}
