package set0000.set000.set060.p060

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "3, 1" should "get 123" in {
    val res = Solution.getPermutation(3, 1)
    res should be("123")
  }

  "3, 3" should "get 213" in {
    val res = Solution.getPermutation(3, 3)
    res should be("213")
  }

  "3, 6" should "get 321" in {
    val res = Solution.getPermutation(3, 6)
    res should be("321")
  }

  "4, 9" should "get 2314" in {
    val res = Solution.getPermutation(4, 9)
    res should be("2314")
  }
}
