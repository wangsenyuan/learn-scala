package set0000.set000.set000.p009

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get true when check 121" in {
    val res = Solution.isPalindrome(121)
    res should be(true)
  }

  it should "get false when check -121" in {
    val res = Solution.isPalindrome(-121)
    res should be(false)
  }

  it should "get false when check 10" in {
    val res = Solution.isPalindrome(10)
    res should be(false)
  }
}
