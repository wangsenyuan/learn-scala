package set0000.set900.set920.p926

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minFlipsMonoIncr("00110")
    res should be(1)
  }
}
