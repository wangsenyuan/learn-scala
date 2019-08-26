package set0000.set000.set050.p051

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "work in example1" in {
    val n = 4
    val res = Solution.solveNQueens(n)
    val expect = List(".Q..,...Q,Q...,..Q.", "..Q.,Q...,...Q,.Q..").sorted
    res.map(grid => grid.mkString(",")).sorted shouldEqual expect
  }
}
