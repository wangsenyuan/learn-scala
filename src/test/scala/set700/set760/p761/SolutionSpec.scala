package set700.set760.p761

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val S = "11011000"
    val res = Solution.makeLargestSpecial(S)
    res should be("11100100")
  }
}
