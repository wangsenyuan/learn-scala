package codechef.easy.k2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/05/2017.
  */
object Main {

  def isPalindromic(n: Long, b: Long): Boolean = {
    if (n % b == 0) {
      false
    } else {
      var left = n / b
      var right = n - b * left
      var q = left / b
      while (q > right) {
        right = b * (right - q) + left
        left = q
        q = left / b
      }
      left == right || q == right
    }
  }

  def smallestBase(n: Long) = {
    var b = 2L
    while (b * b <= n && !isPalindromic(n, b)) {
      b += 1
    }

    if (b * b <= n) {
      b
    } else {
      b -= 1

      var q = n / b
      while (q == b + 1 || q * b != n) {
        b -= 1
        q = n / b
      }

      q - 1
    }
  }

  def solve() = {
    val n = StdIn.readInt()

    val res =
      if (n == 1 || n == 3) {
        2
      } else if (n == 2 || n == 4) {
        3
      } else {
        smallestBase(n)
      }

    println(res)
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
