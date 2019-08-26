package set0000.set700.set790.p799

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.champagneTower(1, 1, 1)
    res should be(0.0)
  }

  "example two" should "work" in {
    val res = Solution.champagneTower(2, 1, 1)
    res should be(.5)
  }
}
