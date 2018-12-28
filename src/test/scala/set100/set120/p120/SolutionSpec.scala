package set100.set120.p120

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example 1" should "give 11" in {
    val triangle = List(
      List(2),
      List(3, 4),
      List(6, 5, 7),
      List(4, 1, 8, 3)
    )

    Solution.minimumTotal(triangle) should be(11)
  }

  "example 2" should "give -1" in {
    val triangle = List(
      List(-1),
      List(3, 2),
      List(1, -2, -1)
    )

    Solution.minimumTotal(triangle) should be(-1)
  }
}
