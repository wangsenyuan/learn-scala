package set000.set070.p076

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "ADOBECODEBANC and ABC" should "get BANC" in {
    val res = Solution.minWindow("ADOBECODEBANC", "ABC")
    res should equal("BANC")
  }

  "a and aa" should "get emtpy" in {
    val res = Solution.minWindow("a", "aa")
    res should equal("")
  }

}
