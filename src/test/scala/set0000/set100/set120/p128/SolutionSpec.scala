package set0000.set100.set120.p128

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "100, 4, 200, 1, 3, 2" should "give 4" in {
    Solution.longestConsecutive(Array(100, 4, 200, 1, 3, 2)) should be(4)
  }

  "[1,2,0,1]" should "give 3" in {
    Solution.longestConsecutive(Array(1, 2, 0, 1)) should be(3)
  }
}
