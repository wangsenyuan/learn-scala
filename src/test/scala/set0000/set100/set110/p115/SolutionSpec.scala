package set0000.set100.set110.p115

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "rabbbit and rabbit" should "get 3" in {
    Solution.numDistinct("rabbbit", "rabbit") should be(3)
  }

  "babgbag and bag" should "get 5" in {
    Solution.numDistinct("babgbag", "bag") should be(5)
  }
}
