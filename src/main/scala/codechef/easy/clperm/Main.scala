package codechef.easy.clperm

import scala.io.StdIn

/**
  * Created by wangsenyuan on 30/03/2017.
  */
object Main {

  def rangeSum(a: Long, b: Long): Long = (a + b) * (b - a + 1) / 2

  def solve(): Long = {
    val firstLine = StdIn.readLine().split("\\s+")

    val n = firstLine(0).toLong
    val k = firstLine(1).toInt

    val missing = StdIn.readLine().split("\\s+").map(_.toLong).sorted

    val num =
      if (k == 0) {
        rangeSum(1, n)
      } else {
        var sum = rangeSum(1, missing(0) - 1)
        var i = 1
        var found = false
        while (i < k && !found) {
          if (missing(i) - missing(i - 1) > 1) {
            if (sum >= missing(i - 1)) {
              sum += rangeSum(missing(i - 1) + 1, missing(i) - 1)
            } else {
              found = true
            }
          }
          i += 1
        }

        if (sum >= missing(k - 1)) {
          sum + rangeSum(missing(k - 1) + 1, n)
        } else {
          sum
        }
      }

    num + 1
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      val missingNum = solve()
      if (missingNum % 2 == 1) {
        println("Chef")
      } else {
        println("Mom")
      }
      i += 1
    }
  }
}
