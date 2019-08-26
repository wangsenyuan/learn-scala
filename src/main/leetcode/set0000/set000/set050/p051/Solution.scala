package set0000.set000.set050.p051

import scala.collection.mutable.ListBuffer

object Solution {

  def solveNQueens(n: Int): List[List[String]] = {
    if (n == 0) {
      Nil
    } else {

      def conflict(i: Int, j: Int, queens: List[(Int, Int)]): Boolean = {
        queens.exists(queen => {
          val (x, y) = queen
          j == y || (i - x == j - y) || (i - x == y - j)
        })
      }

      def findCandidates(i: Int, queens: List[(Int, Int)]): List[Int] = {
        (0 until n).filter(!conflict(i, _, queens)).toList
      }

      def genRow(j: Int): String = {
        ("." * j) + "Q" + ("." * (n - j - 1))
      }

      val res = ListBuffer.empty[List[String]]

      def go(i: Int, rows: Vector[String], queens: List[(Int, Int)]): Unit = {
        if (i == n) {
          res += rows.toList
        } else {
          val candidates = findCandidates(i, queens)
          candidates.foreach(
            j => {
              val row = genRow(j)
              go(i + 1, rows :+ row, (i, j) :: queens)
            }
          )
        }
      }

      go(0, Vector(), Nil)

      res.toList
    }
  }
}
