package set700.set710.p719

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.smallestDistancePair(Array(1, 1, 1), 2)
    res should be(0)
  }

  "example two" should "work" in {
    val res = Solution.smallestDistancePair(Array(1, 3, 1), 1)
    res should be(0)
  }

  "example three" should "work" in {
    val res = Solution.smallestDistancePair(Array(1, 3, 1), 2)
    res should be(2)
  }

  "example four" should "work" in {
    val res = Solution.smallestDistancePair(Array(1, 3, 1), 3)
    res should be(2)
  }
}
