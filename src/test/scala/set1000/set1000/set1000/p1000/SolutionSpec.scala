package set1000.set1000.set1000.p1000

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(3, 2, 4, 1)
    val K = 2
    val res = Solution.mergeStones(arr, K)
    res should be(20)
  }

  "example two" should "work" in {
    val arr = Array(3, 5, 1, 2, 6)
    val K = 3
    val res = Solution.mergeStones(arr, K)
    res should be(25)
  }
}
