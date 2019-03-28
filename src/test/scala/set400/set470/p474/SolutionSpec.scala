package set400.set470.p474

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 4" in {
    val strs = Array("10", "0001", "111001", "1", "0")
    val res = Solution.findMaxForm(strs, 5, 3)
    res should be(4)
  }

  "example two" should "get 2" in {
    val strs = Array("10", "0", "1")
    val res = Solution.findMaxForm(strs, 1, 1)
    res should be(2)
  }
}
