package set0000.set300.set380.p389

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "first example" should "work" in {
    val res = Solution.findTheDifference("abcd", "abcde")
    res should equal('e')
  }
}
