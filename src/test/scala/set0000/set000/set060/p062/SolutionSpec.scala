package set0000.set000.set060.p062

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "3, 2" should "get 3" in {
    val res = Solution.uniquePaths(3, 2)
    res should be(3)
  }

  "7, 3" should "get 28" in {
    val res = Solution.uniquePaths(7, 3)
    res should be(28)
  }
}
