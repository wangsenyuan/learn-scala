package codechef.easy.coolguys

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/03/2017.
  */
object Main {

  def gcd(y: Long, x: Long): Long =
    if (x == 0) {
      y
    } else {
      gcd(x, y % x)
    }

  def solve(n: Int) = {
    var x = 0L
    var k = n
    var i = 1
    while (i <= n) {
      val j = n / k
      x += k * (j - i + 1)
      i = j + 1
      k = n / i
    }

    var y = 1L * n * n

    val z = gcd(y, x)

    x /= z
    y /= z

    println(s"$x/$y")
  }


  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      val n = StdIn.readInt()
      solve(n)
      i += 1
    }
  }
}
