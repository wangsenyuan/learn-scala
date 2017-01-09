package codechef.easy.maxdiff

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/19/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val k = line(1)
      val ws = StdIn.readLine().split("\\s+").map(_.toLong)
      val diff = maxDiff(n, k, ws)
      println(diff)
      t -= 1
    }
  }

  private def maxDiff(n: Int, k: Int, ws: Array[Long]): Long = {
    def kMaxItems(k: Int, xs: Vector[Long]): Vector[Long] = {
      if (xs.isEmpty || k == 0) {
        Vector()
      } else {
        val pivot = xs(0)
        val (a, b) = xs.tail.partition(_ >= pivot)
        if (a.size == k) {
          a
        } else if (a.size > k) {
          kMaxItems(k, a)
        } else {
          (a :+ pivot) ++ kMaxItems(k - a.size - 1, b)
        }
      }
    }
    val m = if (n - k > k) n - k else k
    val km = kMaxItems(m, ws.toVector)
    val total = ws.sum
    val kms = km.sum
    2 * kms - total
  }
}
