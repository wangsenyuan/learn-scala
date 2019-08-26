package set0000.set600.set680.p686

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.repeatedStringMatch("abcd", "cdabcdab")
    res should be(3)
  }
}
