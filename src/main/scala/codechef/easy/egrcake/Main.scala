package codechef.easy.egrcake

import scala.io.StdIn

/**
  * Created by wangsenyuan on 25/04/2017.
  */
object Main {

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val m = line(1)
        val g = gcd(n, m)
        val res = n / g
        if (res == n) {
          println("Yes")
        } else {
          println(s"No $res")
        }
    }
  }
}
