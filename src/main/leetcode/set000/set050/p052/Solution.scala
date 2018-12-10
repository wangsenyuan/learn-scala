package set000.set050.p052

object Solution {

  def totalNQueens(n: Int): Int = {
    def conflict(queens: Vector[Int], i: Int, j: Int): Boolean = {
      queens.zipWithIndex.exists(p => {
        val (y, x) = p
        (y == j) || (i - x == j - y) || (i - x == y - j)
      })
    }

    def findCandidates(queens: Vector[Int], i: Int) = {
      (0 until n).filter(!conflict(queens, i, _))
    }

    def go(queens: Vector[Int], i: Int): Int = {
      if (i == n) {
        1
      } else {
        val cand = findCandidates(queens, i)
        cand.map(j => go(queens :+ j, i + 1)).sum
      }
    }

    go(Vector(), 0)
  }
}
