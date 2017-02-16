package codechef.easy.ppnum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/02/2017.
  */
object Main {

  val M = 1000000007


  def godness(l: Int, r: Int) = {
    def cal(x: Int, y: Int, n: Int): Long = {
      val a = 1L * (y + x)
      val b = 1L * (y - x + 1)
      val c = 1L * n * (a * b / 2)
      c
    }

    var ans = 0L

    var p = 1L
    var i = 1

    while (i < 10) {
      val q = p * 10 - 1
      val x = p max l
      val y = q min r
      if (x <= y) {
        val z = cal((x % M).toInt, (y % M).toInt, i)
        ans = (ans + z) % M
      }
      p *= 10
      i += 1

    }
    if (ans < 0) {
      ans + M
    } else {
      ans
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val l = line(0)
      val r = line(1)

      val ans = godness(l, r)

      println(ans)

      t -= 1
    }
  }
}
