package set800.set840.p849

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val seats = Array(1, 0, 0, 0, 1, 0, 1)
    val res = Solution.maxDistToClosest(seats)
    res should be(2)
  }

  "example two" should "work" in {
    val seats = Array(1, 0, 0, 0)
    val res = Solution.maxDistToClosest(seats)
    res should be(3)
  }

  "example three" should "work" in {
    val seats = Array(1, 0, 0, 1)
    val res = Solution.maxDistToClosest(seats)
    res should be(1)
  }

  "example four" should "work" in {
    val seats = Array(0, 1)
    val res = Solution.maxDistToClosest(seats)
    res should be(1)
  }

  "example five" should "work" in {
    val seats = Array(0, 0, 1)
    val res = Solution.maxDistToClosest(seats)
    res should be(2)
  }
}
