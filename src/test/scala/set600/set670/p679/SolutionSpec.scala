package set600.set670.p679

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.judgePoint24(Array(4, 1, 8, 7))
    res should be(true)
  }

  "example two" should "work" in {
    val res = Solution.judgePoint24(Array(1, 2, 1, 2))
    res should be(false)
  }

  "example three" should "work" in {
    val res = Solution.judgePoint24(Array(1, 9, 1, 2))
    res should be(true)
  }

  "example four" should "work" in {
    val res = Solution.judgePoint24(Array(3, 3, 8, 8))
    res should be(true)
  }

  "example five" should "work" in {
    val res = Solution.judgePoint24(Array(1, 1, 7, 7))
    res should be(false)
  }

  "example six" should "work" in {
    val res = Solution.judgePoint24(Array(3,4,6,7))
    res should be(false)
  }
}
