package set0000.set300.set340.p342

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "16" should "be power of 4" in {
    Solution.isPowerOfFour(16) should be(true)
  }
}
