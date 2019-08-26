package set0000.set000.set090.p095

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "3" should "get 5 unique bst-s" in {
    val res = Solution.generateTrees(3)
    res.size should be(5)
  }
}
