package set1000.set1000.set1000.p1003

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.isValid("abcabcababcc")
    res should be(true)
  }

  "example two" should "work" in {
    val res = Solution.isValid("aabbcc")
    res should be(false)
  }
}
