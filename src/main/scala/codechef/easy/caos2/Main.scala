package codechef.easy.caos2

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val primes = Array.fill(251)(true)
    val cnts = Array.fill(251)(0)

    var x = 2
    while (x <= 250) {
      cnts(x) = cnts(x - 1)
      if (primes(x)) {
        cnts(x) += 1
        var y = 2 * x
        while (y <= 250) {
          primes(y) = false
          y += x
        }
      }
      x += 1
    }

    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve(cnts)
      i += 1
    }
  }

  def solve(cnts: Array[Int]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val r = firstLine(0)
    val c = firstLine(1)
    val map = Array.fill[Array[Char]](r)(null)
    var i = 0
    while (i < r) {
      map(i) = StdIn.readLine().toCharArray
      i += 1
    }

    val L = Array.fill(r, c)(0)
    val T = Array.fill(r, c)(0)
    val R = Array.fill(r, c)(0)
    val B = Array.fill(r, c)(0)

    i = 0
    while (i < r) {
      var j = 0
      while (j < c) {
        if (map(i)(j) == '#') {
          L(i)(j) = 0
          T(i)(j) = 0
        } else {
          L(i)(j) = 1
          if (j > 0) {
            L(i)(j) += L(i)(j - 1)
          }
          T(i)(j) = 1
          if (i > 0) {
            T(i)(j) += T(i - 1)(j)
          }
        }
        j += 1
      }
      i += 1
    }

    i = r - 1
    while (i >= 0) {
      var j = c - 1
      while (j >= 0) {
        if (map(i)(j) == '#') {
          R(i)(j) = 0
          B(i)(j) = 0
        } else {
          R(i)(j) = 1
          if (j < c - 1) {
            R(i)(j) += R(i)(j + 1)
          }
          B(i)(j) = 1
          if (i < r - 1) {
            B(i)(j) += B(i + 1)(j)
          }
        }
        j -= 1
      }
      i -= 1
    }

    var ans = 0
    i = 0
    while (i < r) {
      var j = 0
      while (j < c) {
        if (map(i)(j) == '^') {
          val X = (L(i)(j) min T(i)(j) min R(i)(j) min B(i)(j)) - 1
          ans += cnts(X)
        }

        j += 1
      }
      i += 1
    }

    println(ans)
  }
}
