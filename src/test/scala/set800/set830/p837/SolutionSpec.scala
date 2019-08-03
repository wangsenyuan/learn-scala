package set800.set830.p837

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.new21Game(6, 1, 10)
    res should be(0.6)
  }

  "example two" should "work" in {
    val res = Solution.new21Game(21, 17, 10)
    (res - 0.73278) should be < 1e-5
  }
}
