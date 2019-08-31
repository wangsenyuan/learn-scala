package set0000.set800.set890.p893

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numSpecialEquivGroups(Array("abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"))
    res should be(3)
  }
}
