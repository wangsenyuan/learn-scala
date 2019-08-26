package set0000.set600.set640.p647

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "abc" should "get 3" in {
    val res = Solution.countSubstrings("abc")
    res should be(3)
  }

  "aaa" should "get 6" in {
    val res = Solution.countSubstrings("aaa")
    res should be(6)
  }
}
