package set100.set170.p172

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1808548329" should "get 452137076" in {
    val res = Solution.trailingZeroes(1808548329)
    res should be(452137076)
  }

  "5" should "get 1" in {
    val res = Solution.trailingZeroes(5)
    res should be(1)
  }

  "2147483647" should "get 536870902" in {
    val res = Solution.trailingZeroes(2147483647)
    res should be(536870902)
  }
}
