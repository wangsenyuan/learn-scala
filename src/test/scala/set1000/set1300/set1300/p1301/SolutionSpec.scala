package set1000.set1300.set1300.p1301

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val board = List("E23", "2X2", "12S")
    val res = Solution.pathsWithMaxScore(board)
    res should be(Array(7, 1))
  }
}
