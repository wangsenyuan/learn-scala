package set000.set050.p052

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 2 when given 4" in {
    val res = Solution.totalNQueens(4)
    res shouldBe 2
  }
}
