package codechef.easy.gardensq

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/2/5.
  */
object Main {

  def findElegantSquares(garden: Array[String], n: Int, m: Int): Int = {
    var res = 0
    for {
      i <- 0 until (n - 1)
      j <- 0 until (m - 1)
      k <- 1 until n
      if i + k < n && j + k < m &&
        garden(i)(j) == garden(i + k)(j) &&
        garden(i)(j) == garden(i)(j + k) &&
        garden(i)(j) == garden(i + k)(j + k)
    } {
      res += 1
    }

    res
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val m = line(1)
      val garden = Array.fill[String](n)(null)

      var i = 0
      while (i < n) {
        garden(i) = StdIn.readLine()
        i += 1
      }

      val res = findElegantSquares(garden, n, m)

      println(res)

      t -= 1
    }
  }
}
