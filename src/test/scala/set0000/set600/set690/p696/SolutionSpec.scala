package set0000.set600.set690.p696

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.countBinarySubstrings("00110")
    res should be(3)
  }
}
