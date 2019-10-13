package set0000.set900.set990.p992

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.subarraysWithKDistinct(Array(1, 2, 1, 2, 3), 2)
    res should be(7)
  }

  "example two" should "work" in {
    val res = Solution.subarraysWithKDistinct(Array(1, 2, 1, 3, 4), 3)
    res should be(3)
  }
}
