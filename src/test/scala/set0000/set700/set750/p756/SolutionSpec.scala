package set0000.set700.set750.p756

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.pyramidTransition("AABA", List("AAA", "AAB", "ABA", "ABB", "BAC"))
    res should be(false)
  }
}
