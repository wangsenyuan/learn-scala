package set0000.set200.set270.p274

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[3,0,6,1,5]" should "get 3" in {
    val citations = Array(3, 0, 6, 1, 5)
    val res = Solution.hIndex(citations)
    res should be(3)
  }
}
