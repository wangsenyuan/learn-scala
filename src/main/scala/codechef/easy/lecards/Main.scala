package codechef.easy.lecards

import scala.io.StdIn

object Main {


  def main(args: Array[String]): Unit = {
    val comb = preComputeComb(1000)
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve(comb)
      i += 1
    }
  }

  val MOD = 1000000007

  def preComputeComb(n: Int): Array[Array[Long]] = {
    val c = Array.fill(n + 1, n + 1)(0L)
    c(0)(0) = 1

    var i = 1
    while (i <= n) {
      var j = 0
      while (j < i) {
        c(i)(j) = c(i - 1)(j)
        if (j > 0) {
          c(i)(j) = (c(i)(j) + c(i - 1)(j - 1)) % MOD
        }
        j += 1
      }

      c(i)(i) = 1

      i += 1
    }

    c
  }

  def solve(comb: Array[Array[Long]]): Unit = {
    val n = StdIn.readInt()
    StdIn.readLine()

    var ans = 0L
    var i = n / 2 + 1

    while (i <= n) {
      ans = (ans + comb(n)(i)) % MOD
      i += 1
    }

    println(ans)
  }
}
