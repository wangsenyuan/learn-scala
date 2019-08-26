package set0000.set000.set060.p066

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[1,2,3] plus one" should "be [1, 2, 4]" in {
    val arr = Array(1, 2, 3)
    val res = Solution.plusOne(arr)
    res shouldEqual Array(1, 2, 4)
  }
}
