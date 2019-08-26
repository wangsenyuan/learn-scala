package set0000.set800.set870.p874

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.robotSim(Array(4, -1, 3), Array())
    res should be(25)
  }

  "example two" should "work" in {
    val res = Solution.robotSim(Array(4, -1, 4, -2, 4), Array(Array(2, 4)))
    res should be(65)
  }
}
