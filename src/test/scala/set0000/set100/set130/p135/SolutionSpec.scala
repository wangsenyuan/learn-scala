package set0000.set100.set130.p135

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,0,2]" should "get 5" in {
    val ratings = Array(1, 0, 2)
    Solution.candy(ratings) should be(5)
  }

  "[1,2,2]" should "get 4" in {
    val ratings = Array(1, 2, 2)
    Solution.candy(ratings) should be(4)
  }
}
