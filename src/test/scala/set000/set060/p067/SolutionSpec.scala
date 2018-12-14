package set000.set060.p067

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "add (11, 1)" should "get 100" in {
    val res = Solution.addBinary("11", "1")
    res should be("100")
  }

  "add (1010, 1011)" should "get 10101" in {
    val res = Solution.addBinary("1010", "1011")
    res should be("10101")
  }
}
