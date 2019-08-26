package set0000.set200.set220.p221

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 4" in {
    val matrix = Array("10100", "10111", "11111", "10010").map(_.toCharArray)
    val res = Solution.maximalSquare(matrix)
    res should be(4)
  }
}
