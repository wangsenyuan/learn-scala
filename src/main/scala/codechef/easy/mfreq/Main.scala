package codechef.easy.mfreq

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    val left = Array.fill(n)(0)
    val right = Array.fill(n)(n - 1)

    var i = 1
    while (i < n) {
      left(i) =
        if (nums(i) == nums(i - 1)) {
          left(i - 1)
        } else {
          i
        }

      i += 1
    }

    i = n - 2
    while (i >= 0) {
      right(i) =
        if (nums(i) == nums(i + 1)) {
          right(i + 1)
        } else {
          i
        }
      i -= 1
    }

    i = 0
    while (i < m) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = line(0) - 1
      val b = line(1) - 1
      val k = line(2)

      val mid = a + (b - a) / 2
      val c = a max left(mid)
      val d = b min right(mid)
      if (d - c + 1 >= k) {
        println(nums(mid))
      } else {
        println(-1)
      }

      i += 1
    }
  }
}
