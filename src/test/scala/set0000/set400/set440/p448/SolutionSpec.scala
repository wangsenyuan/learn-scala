package set0000.set400.set440.p448

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[4,3,2,7,8,2,3,1]" should "get [5, 6]" in {
    val res = Solution.findDisappearedNumbers(Array(4, 3, 2, 7, 8, 2, 3, 1))
    res should be(List(5, 6))
  }
}
