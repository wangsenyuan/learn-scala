package set1000.set1100.set1100.p1104

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.pathInZigZagTree(14)
    res should be(Array(1, 3, 4, 14))
  }

  "example two" should "work" in {
    val res = Solution.pathInZigZagTree(26)
    res should be(Array(1, 2, 6, 10, 26))
  }

  "example three" should "work" in {
    val res = Solution.pathInZigZagTree(16)
    res should be(Array(1, 3, 4, 15, 16))
  }
}
