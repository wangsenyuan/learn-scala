package set000.set090.p096

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "3" should "give 5" in {
    Solution.numTrees(3) should be(5)
  }
}
