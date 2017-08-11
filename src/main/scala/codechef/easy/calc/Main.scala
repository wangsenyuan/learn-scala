package codechef.easy.calc

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)

    val n = line(0)
    val b = line(1)

    val y = n / (2 * b)

    def calculate(y: Long): Long = (n - b * y) * y

    val ans =
      if (2 * b * y == n) {
        calculate(y)
      } else {
        calculate(y) max calculate(y + 1)
      }

    println(ans)
  }
}
