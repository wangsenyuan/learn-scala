package set0000.set800.set860.p866

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.primePalindrome(13)
    res should be(101)
  }

  "example two" should "work" in {
    val res = Solution.primePalindrome(10000000)
    res should be(181)
  }
}
