package set0000.set300.set310.p315

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[5,2,6,1]" should "get [2,1,1,0]" in {
    val res = Solution.countSmaller(Array(5, 2, 6, 1))
    res should equal(List(2, 1, 1, 0))
  }

  "[2,0,1]" should "get [2, 0, 0]" in {
    val res = Solution.countSmaller(Array(2, 0, 1))
    res should equal(List(2, 0, 0))
  }
}
