package set400.set480.p486

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "get false" in {
    val res = Solution.PredictTheWinner(Array(1, 5, 2))
    res should be(false)
  }

  "example two" should "get true" in {
    val res = Solution.PredictTheWinner(Array(1, 5, 233, 7))
    res should be(true)
  }
}
