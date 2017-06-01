package codechef.easy.reign

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/20.
  */
object Main {

  def calculateMaxSum(xs: Array[Long]): Array[Long] = {
    val n = xs.length
    val ys = Array.fill(n)(Long.MinValue)
    var sum = 0L
    var i = 0
    while (i < n) {
      if (i > 0) {
        ys(i) = ys(i - 1)
      }

      sum += xs(i)

      if (sum > ys(i)) {
        ys(i) = sum
      }

      if (sum < 0) {
        sum = 0
      }

      i += 1
    }

    ys
  }

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val xs = StdIn.readLine().split("\\s+").map(_.toLong)

    val as = calculateMaxSum(xs)
    val bs = calculateMaxSum(xs.reverse).reverse
    var res = Long.MinValue
    var i = 0
    while (i + k + 1 < n) {
      val j = i + k + 1

      if (as(i) + bs(j) > res) {
        res = as(i) + bs(j)
      }

      i += 1
    }

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
