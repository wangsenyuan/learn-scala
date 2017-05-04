package codechef.easy.abrepeat

import scala.io.StdIn

/**
  * Created by wangsenyuan on 02/05/2017.
  */
object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val s = StdIn.readLine()

    val bx = Array.fill(n)(0)

    var i = n - 1
    while (i >= 0) {
      if (i < n - 1) {
        bx(i) = bx(i + 1)
      }
      if (s(i) == 'b') {
        bx(i) += 1
      }
      i -= 1
    }
    val m = 1l * bx(0) * k * (k - 1) / 2

    var res = 0L
    i = 0
    while (i < n) {
      if (s(i) == 'a') {
        res += 1l * k * bx(i) + m
      }
      i += 1
    }

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
