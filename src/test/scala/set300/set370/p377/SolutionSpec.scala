package set300.set370.p377

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1, 2, 3] and 4" should "get 7" in {
    val res = Solution.combinationSum4(Array(1, 2, 3), 4)
    res should be(7)
  }

  "[3, 33, 333] and 10000" should "get 0" in {
    val res = Solution.combinationSum4(Array(3, 33, 333), 10000)
    res should be(0)
  }

  "[1, 50] and 200" should "get 28730" in {
    val res = Solution.combinationSum4(Array(1, 50), 200)
    res should be(28730)
  }
}
