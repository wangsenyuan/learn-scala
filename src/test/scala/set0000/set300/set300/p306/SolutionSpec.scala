package set0000.set300.set300.p306

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "112358" should "be additive" in {
    Solution.isAdditiveNumber("112358") should be(true)
  }

  "199100199" should "be additive" in {
    Solution.isAdditiveNumber("199100199") should be(true)
  }

  "123" should "be additive" in {
    Solution.isAdditiveNumber("123") should be(true)
  }

  "12" should "not be additive" in {
    Solution.isAdditiveNumber("12") should be(false)
  }
}
