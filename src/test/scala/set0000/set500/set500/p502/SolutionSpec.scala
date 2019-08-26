package set0000.set500.set500.p502

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.findMaximizedCapital(2, 0, Array(1, 2, 3), Array(0, 1, 1))
    res should be(4)
  }
}
