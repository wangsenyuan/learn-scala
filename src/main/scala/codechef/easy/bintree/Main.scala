package codechef.easy.bintree

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val line = StdIn.readLine().split("\\s+").map(_.toLong)
      val a = line(0)
      val b = line(1)

      val res = shortestPath(a, b)

      println(res)
    }
  }

  private def shortestPath(a: Long, b: Long): Int = {
    @tailrec
    def go(a: Long, b: Long, res: Int): Int = {
      if (a == b) {
        res
      } else if (a > b) {
        go(a / 2, b, res + 1)
      } else {
        go(a, b / 2, res + 1)
      }
    }

    go(a, b, 0)
  }
}
