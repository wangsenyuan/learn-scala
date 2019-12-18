package set1000.set1200.set1230.p1234

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.balancedString("WWEQERQWQWWRWWERQWEQ")
    res should be(4)
  }

  "example two" should "work" in {
    val res = Solution.balancedString("QERR")
    res should be(1)
  }
}
