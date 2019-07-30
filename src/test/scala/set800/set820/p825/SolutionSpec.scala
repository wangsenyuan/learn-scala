package set800.set820.p825

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val res = Solution.numFriendRequests(Array(16,16))
    res should be(2)
  }

  "example two" should "work" in {
    val res = Solution.numFriendRequests(Array(16,17,18))
    res should be(2)
  }

  "example three" should "work" in {
    val res = Solution.numFriendRequests(Array(20,30,100,110,120))
    res should be(3)
  }


  "example four" should "work" in {
    val res = Solution.numFriendRequests(Array(108,115,5,24,82))
    res should be(3)
  }

  "example five" should "work" in {
    val res = Solution.numFriendRequests(Array(118,14,7,63,103))
    res should be(2)
  }
}
