package set0000.set100.set170.p171

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "FXSHRXW" should "get 2147483647" in {
    val res = Solution.titleToNumber("FXSHRXW")
    res should be(2147483647)
  }

}
