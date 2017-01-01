package codechef.grid

import scala.io.StdIn

/**
  * Created by senyuanwang on 2016/12/31.
  */
object Main {

  def findPossibleMirrorCells(n: Int, grid: Array[String]) = {
    val cells = Array.fill(n, n)(0)
    var res = 0
    for {
      i <- (n - 1) to 0 by -1
      j <- (n - 1) to 0 by -1
      if grid(i)(j) == '.'
    } {
      if (i == n - 1 || (cells(i + 1)(j) & 1) == 1) {
        cells(i)(j) |= 1
      }

      if (j == n - 1 || (cells(i)(j + 1) & 2) == 2) {
        cells(i)(j) |= 2
      }

      if (cells(i)(j) == 3) {
        res += 1
      }
    }

    res
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()
      val grid = Array.fill(n)("")
      var i = 0
      while (i < n) {
        grid(i) = StdIn.readLine()
        i += 1
      }

      val res = findPossibleMirrorCells(n, grid)
      println(res)
    }
  }
}
