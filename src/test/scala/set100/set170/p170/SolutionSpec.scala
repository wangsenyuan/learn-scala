package set100.set170.p170

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "FXSHRXW" should "get 2147483647" in {
    val res = Solution.titleToNumber("FXSHRXW")
    res should be(2147483647)
  }

}
