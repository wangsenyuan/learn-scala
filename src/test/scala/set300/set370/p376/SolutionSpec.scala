package set300.set370.p376

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,7,4,9,2,5]" should "get 6" in {
    val res = Solution.wiggleMaxLength(Array(1, 7, 4, 9, 2, 5))
    res should be(6)
  }
}
