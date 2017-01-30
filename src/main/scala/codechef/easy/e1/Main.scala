package codechef.easy.e1

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/27.
  */
object Main {

  def moveKnight(board: Array[Array[Char]], n: Int): Int = {
    val dp = Array.fill(n, n)(0)

    for {
      i <- 0 until n
      j <- 0 until n
    } {
      dp(i)(j) =
        if (board(i)(j) == 'P') {
          1
        } else {
          0
        }
    }

    var ki = -1
    var kj = -1

    for {
      i <- 0 until n
      j <- 0 until n
      if ki < 0 && board(i)(j) == 'K'
    } {
      ki = i
      kj = j
    }

    def dpv(i: Int, j: Int): Int = {
      if (i < 0 || j < 0 || i >= n || j >= n) {
        0
      } else {
        dp(i)(j)
      }
    }

    var j = n - 1
    while (j >= 0) {
      var i = 0
      while (i < n) {
        dp(i)(j) += dpv(i - 2, j + 1) max dpv(i + 2, j + 1) max dpv(i + 1, j + 2) max dpv(i - 1, j + 2)
        i += 1
      }

      j -= 1
    }

    dp(ki)(kj)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val board = Array.fill(n)(Array.empty[Char])

      var i = 0
      while (i < n) {
        board(i) = StdIn.readLine().toCharArray
        i += 1
      }

      val res = moveKnight(board, n)

      println(res)
      t -= 1
    }
  }
}
