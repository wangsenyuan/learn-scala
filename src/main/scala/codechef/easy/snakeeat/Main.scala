package codechef.easy.snakeeat

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
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val q = firstLine(1)
    val ls = 0 +: (StdIn.readLine().split("\\s+").map(_.toInt).sorted)
    val ks = Array.fill(q)(0)
    var i = 0
    while (i < q) {
      ks(i) = StdIn.readInt()
      i += 1
    }
    val qr = ks.zipWithIndex.sortBy(_._1)

    val ans = Array.fill(n)(0)
    var cur = 0
    var prev = 0
    var presum = 0L
    i = 1
    while (cur < q) {
      val fir = qr(cur)._1
      while (i <= n && ls(i) < fir) {
        presum += (fir - ls(i))
        i += 1
      }
      i -= 1
      while (presum > prev) {
        prev += 1
        presum -= (fir - ls(prev))
      }

      ans(qr(cur)._2) = n - prev
      if (cur < q - 1) {
        presum = presum + (i - prev) * (qr(cur + 1)._1 - fir)
      }
      cur += 1
      i += 1
    }

    i = 0
    while (i < q) {
      println(ans(i))
      i += 1
    }
  }

  def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var i = 0
    var j = n
    while (i < j) {
      val mid = i + (j - i) / 2
      if (fn(mid)) {
        j = mid
      } else {
        i = mid + 1
      }
    }
    j
  }
}
