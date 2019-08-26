package set0000.set400.set460.p467

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "cac" should "get 2" in {
    val res = Solution.findSubstringInWraproundString("cac")
    res should be(2)
  }

  "zab" should "get 6" in {
    val res = Solution.findSubstringInWraproundString("zab")
    res should be(6)
  }
}
