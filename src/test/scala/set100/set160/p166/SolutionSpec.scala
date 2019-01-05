package set100.set160.p166

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2/3" should "get 0.(6)" in {
    val res = Solution.fractionToDecimal(2, 3)
    res should equal("0.(6)")
  }

  "-50/8" should "get -6.25" in {
    val res = Solution.fractionToDecimal(-50, 8)
    res should equal("-6.25")
  }
}
