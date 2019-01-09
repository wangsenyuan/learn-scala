package set200.set200.p202

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "19" should "be happy" in {
    Solution.isHappy(19) should be(true)
  }
}
