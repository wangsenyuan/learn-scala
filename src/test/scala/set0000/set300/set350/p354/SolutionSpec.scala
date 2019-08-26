package set0000.set300.set350.p354

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[[5,4],[6,4],[6,7],[2,3]]" should "get 3" in {
    val envs = Array(Array(5, 4), Array(6, 4), Array(6, 7), Array(2, 3))
    val res = Solution.maxEnvelopes(envs)
    res should be(3)
  }

  "[[1,2],[2,1],[2,2],[3,3]]" should "get 2" in {
    val envs = Array(Array(1, 2), Array(2, 1), Array(2, 2), Array(3, 3))
    val res = Solution.maxEnvelopes(envs)
    res should be(2)
  }


  "Array(1, 3), Array(3, 5), Array(6, 7), Array(6, 8), Array(8, 4), Array(9, 5)" should "get 3" in {
    val envs = Array(Array(1, 3), Array(3, 5), Array(6, 7), Array(6, 8), Array(8, 4), Array(9, 5))
    val res = Solution.maxEnvelopes(envs)
    res should be(3)
  }

  "Array(2, 100), Array(3, 200), Array(4, 300), Array(5, 500), Array(5, 400), Array(5, 250), Array(6, 370), Array(6, 360), Array(7, 380)" should "get 3" in {
    val envs = Array(Array(2, 100), Array(3, 200), Array(4, 300), Array(5, 500), Array(5, 400), Array(5, 250), Array(6, 370), Array(6, 360), Array(7, 380))
    val res = Solution.maxEnvelopes(envs)
    res should be(5)
  }
}
