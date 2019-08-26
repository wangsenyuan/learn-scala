package set0000.set300.set350.p355

import org.scalatest.{FlatSpec, Matchers}

class TwitterSpec extends FlatSpec with Matchers {
  "example" should "work" in {
    val twitter = new Twitter()
    twitter.postTweet(1, 5)
    var feed = twitter.getNewsFeed(1)
    feed should equal(List(5))
    twitter.follow(1, 2)
    twitter.postTweet(2, 6)

    feed = twitter.getNewsFeed(1)
    feed should equal(List(6, 5))
    twitter.unfollow(1, 2)

    feed = twitter.getNewsFeed(1)
    feed should equal(List(5))
  }
}
