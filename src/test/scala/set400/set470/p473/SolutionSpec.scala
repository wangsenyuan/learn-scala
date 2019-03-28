package set400.set470.p473

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,1,2,2,2]" should "be true" in {
    val res = Solution.makesquare(Array(1, 1, 2, 2, 2))
    res should be(true)
  }

  "[3,3,3,3,4]" should "be false" in {
    val res = Solution.makesquare(Array(3,3,3,3,4))
    res should be(false)
  }

  "[5,5,5,5,16,4,4,4,4,4,3,3,3,3,4]" should "be false" in {
    val res = Solution.makesquare(Array(5,5,5,5,16,4,4,4,4,4,3,3,3,3,4))
    res should be(false)
  }
}
