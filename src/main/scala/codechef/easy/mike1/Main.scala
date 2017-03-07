package codechef.easy.mike1

import scala.io.StdIn

/**
  * Created by wangsenyuan on 07/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val matrix = Array.fill[Array[Int]](n)(null)

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      matrix(i) = line
      i += 1
    }

    var e1 = 0L
    var e2 = 0L

    var l = StdIn.readInt()
    while (l > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val i = line(0) - 1
      val j = line(1) - 1

      if (e1 >= 0) {
        if (i >= 0 && i < n && j >= 0 && j < m) {
          e1 += matrix(i)(j)
        } else {
          e1 = -1
        }
      }

      if (e2 >= 0) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
          e2 += matrix(j)(i)
        } else {
          e2 = -1
        }
      }

      l -= 1
    }

    println(e1 max e2)
  }
}
