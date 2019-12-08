package set1000.set1100.set1180.p1187

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.makeArrayIncreasing(Array(1, 5, 3, 6, 7), Array(1, 3, 2, 4))
    res should be(1)
  }

  "example two" should "work" in {
    val res = Solution.makeArrayIncreasing(Array(1, 5, 3, 6, 7), Array(4, 3, 1))
    res should be(2)
  }

  "example three" should "work" in {
    val res = Solution.makeArrayIncreasing(Array(1, 5, 3, 6, 7), Array(1, 6, 3, 3))
    res should be(-1)
  }
}
