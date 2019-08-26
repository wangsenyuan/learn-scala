package set0000.set700.set710.p712

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.minimumDeleteSum("sea", "eat")
    res should equal(231)
  }
}
