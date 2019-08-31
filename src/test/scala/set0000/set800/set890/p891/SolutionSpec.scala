package set0000.set800.set890.p891

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(2, 1, 3)
    val res = Solution.sumSubseqWidths(arr)
    res should be(6)
  }

  "example two" should "work" in {
    val arr = Array(2, 1, 3, 4, 5, 6, 7)
    val res = Solution.sumSubseqWidths(arr)
    res should be(522)
  }
}
