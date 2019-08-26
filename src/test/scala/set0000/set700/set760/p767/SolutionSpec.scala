package set0000.set700.set760.p767

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.reorganizeString("aab")
    res should be("aba")
  }
}
