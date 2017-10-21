package codechef.easy.mike3

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val offers = Array.fill[Array[Int]](m)(null)
    val ids = Array.fill(n, m)(false)

    var i = 0
    while (i < m) {
      offers(i) = StdIn.readLine().split("\\s+").map(_.toInt).tail
      var j = 0
      while (j < offers(i).length) {
        val x = offers(i)(j)
        ids(x - 1)(i) = true
        j += 1
      }
      i += 1
    }

    val conflicts = Array.fill(m)(0)

    i = 0
    while (i < n) {

      var mask = 0
      var j = 0
      while (j < m) {
        if (ids(i)(j)) {
          mask |= 1 << j
        }
        j += 1
      }

      j = 0
      while (j < m) {
        if (ids(i)(j)) {
          conflicts(j) |= mask
        }
        j += 1
      }

      i += 1
    }

    def dfs(i: Int, mask: Int, sum: Int): Int = {
      if (i == m) {
        sum
      } else {
        val tmp = dfs(i + 1, mask, sum)

        if (((mask >> i) & 1) == 0) {
          tmp max dfs(i + 1, mask | conflicts(i), sum + 1)
        } else {
          tmp
        }
      }
    }

    val ans = dfs(0, 0, 0)
    println(ans)
  }
}
