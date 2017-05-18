package codechef.easy.dumpling

import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/05/2017.
  */
object Main {

  def gcd(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val A = line(0)
    val B = line(1)
    val C = line(2)
    val D = line(3)
    val K = line(4)
    val X = gcd(A, B)
    val Y = gcd(C, D)

    val N = gcd(X, Y)
    val S = X / N
    val R = K / S
    val T = R / Y

    println(2 * T + 1)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }
}
