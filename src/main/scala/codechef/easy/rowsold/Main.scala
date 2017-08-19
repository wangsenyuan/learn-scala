package codechef.easy.rowsold

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }

  def solve(): Unit = {
    val line = StdIn.readLine()
    val n = line.length
    val cnts = Array.fill(n)(0)

    if (line(n - 1) == '0') {
      cnts(n - 1) = 1
    }

    var i = n - 2
    while (i >= 0) {
      cnts(i) = cnts(i + 1)

      if (line(i) == '0' && line(i + 1) == '1') {
        cnts(i) += 1
      }

      i -= 1
    }

    var ans = 0L

    var j = n - 1
    i = n - 1
    while (i >= 0) {
      if (line(i) == '1') {
        ans += j - i
        j -= 1
      }
      i -= 1
    }

    i = 0
    while (i < n) {
      if (line(i) == '1') {
        ans += cnts(i)
      }
      i += 1
    }

    println(ans)
  }
}
