package codechef.easy.lucky1

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  def f(x: Int, b: Int): Int = {
    var cnt = 0
    var y = x
    while (y > 0) {
      if (b == y % 10) {
        cnt += 1
      }

      y = y / 10
    }

    cnt
  }

  def main(args: Array[String]): Unit = {
    val specialBuf = ListBuffer.empty[Int]

    val N = 1000001
    val sum = Array.fill(N)(0l)
    val cnt = Array.fill(N)(0l)
    var fours = 0L
    var sevens = 0L
    sum(0) = 1
    var x = 1
    while (x < N) {
      val four = f(x, 4)
      val seven = f(x, 7)

      fours += four
      sevens += seven

      val diff = (fours - sevens).toInt

      cnt(x) += cnt(x - 1) + sum(diff)

      sum(diff) += 1

      x += 1
    }

    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      val n = StdIn.readInt()
      println(cnt(n))
      i += 1
    }
  }
}
