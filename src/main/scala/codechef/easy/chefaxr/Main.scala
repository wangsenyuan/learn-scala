package codechef.easy.chefaxr

import scala.io.StdIn

object Main {

  def solve() = {
    val n = StdIn.readInt()

    val xor = Array.fill(n, n)(0)
    var i = 0

    while (i < n) {
      val row = StdIn.readLine().split("\\s+").map(_.toInt)

      var j = 0
      while (j < n) {
        xor(i)(j) = row(j)
        if (i > 0) {
          xor(i)(j) ^= xor(i - 1)(j)
        }
        if (j > 0) {
          xor(i)(j) ^= xor(i)(j - 1)
        }

        if (i > 0 && j > 0) {
          xor(i)(j) ^= xor(i - 1)(j - 1)
        }
        j += 1
      }

      i += 1
    }

    var ans = 0

    for {
      i <- 0 until n
      j <- 0 until n
      a <- i until n
      b <- j until n
    } {
      var tmp = xor(a)(b)
      if (i > 0) {
        tmp ^= xor(i - 1)(b)
      }

      if (j > 0) {
        tmp ^= xor(a)(j - 1)
      }

      if (i > 0 && j > 0) {
        tmp ^= xor(i - 1)(j - 1)
      }

      if (tmp > ans) {
        ans = tmp
      }
    }

    println(ans)

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
