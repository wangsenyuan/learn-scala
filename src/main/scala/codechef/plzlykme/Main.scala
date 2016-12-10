package codechef.plzlykme

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1

      val line = StdIn.readLine().split("\\s+").map(_.toLong)
      val l = line(0)
      val d = line(1)
      val s = line(2)
      val c = line(3)

      if (checkLike(l, d, c, s)) {
        println("ALIVE AND KICKING")
      } else {
        println("DEAD AND ROTTING")
      }

    }
  }

  def checkLike(l: Long, d: Long, c: Long, s: Long): Boolean = {
    val log = Math.log _

    log(s) + (d - 1) * log(1 + c) >= log(l)
  }

  /*
    def pow(a: Long, b: Long): Long = {
      if (b == 0) {
        1L
      } else if (b == 1) {
        a
      } else if (b % 2 == 0) {
        val r = pow(a, b / 2)
        r * r
      } else {
        val r = pow(a, b / 2)
        r * r * a
      }
    }

    implicit class PowOp(val x: Long) {
      def **(y: Long): Long = pow(x, y)
    }
  */
}
