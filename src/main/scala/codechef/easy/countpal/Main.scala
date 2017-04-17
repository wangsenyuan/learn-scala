package codechef.easy.countpal

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/17.
  */
object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val s = StdIn.readLine()
    val n = s.length
    val p = Array.fill(n, n)(false)

    var k = 1
    while (k <= n) {
      var i = 0
      while (i + k <= n) {
        val j = i + k - 1
        if (i == j) {
          p(i)(j) = true
        } else if (s(i) == s(j)) {
          if (j == i + 1) {
            p(i)(j) = true
          } else {
            p(i)(j) = p(i + 1)(j - 1)
          }
        }

        i += 1
      }
      k += 1
    }

    val f = Array.fill(n + 1)(0L)

    f(0) = 1

    var i = 1
    while (i <= n) {
      var j = 0
      while (j < i) {
        if (p(j)(i - 1)) {
          f(i) = (f(i) + f(j)) % MOD
        }
        j += 1
      }

      i += 1
    }

    println(f(n))
  }
}
