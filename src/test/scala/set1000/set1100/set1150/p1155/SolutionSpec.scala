package set1000.set1100.set1150.p1155

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numRollsToTarget(2, 6, 7)
    res should be(6)
  }
}
