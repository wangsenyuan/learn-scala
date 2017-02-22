package codechef.easy.misinter

import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/02/2017.
  */
object Main {

  val M = 1000000007

  def fastPow(x: Int, n: Int): Long = {
    if (n == 0) {
      1
    } else {
      val y = fastPow(x, n / 2)
      val z = y * y % M
      if (n % 2 == 1) {
        z * x % M
      } else {
        z
      }
    }
  }

  def calculate(n: Int): Long = {
    val p = Array.fill(n + 1)(0)
    var i = 1
    (2 to n by 2) foreach {
      x =>
        p(i) = x
        i += 1
    }

    (1 to n by 2) foreach {
      x =>
        p(i) = x
        i += 1
    }

    val m = Array.fill(n + 1)(false)

    var cycles = 0

    (1 to n) foreach {
      i =>
        if (!m(i)) {
          cycles += 1
          var j = i
          while (!m(j)) {
            m(j) = true
            j = p(j)
          }
        }
    }

    fastPow(26, cycles)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {

      val n = StdIn.readInt()

      val r = calculate(n)
      println(r)

      t -= 1
    }
  }
}
