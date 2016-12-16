package codechef.kthmax

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {

  def calculate(q: Long, n: Int) = {

    @tailrec
    def bs(l: Int, r: Int): Int = {
      if (l > r) {
        l
      } else {
        val i = l + (r - l) / 2
        if (1l * (2 * n - i) * (i + 1) / 2 <= q) {
          bs(i + 1, r)
        } else {
          bs(l, i - 1)
        }
      }
    }

    val i = bs(0, n - 1)
    (i, (q - 1L * (2 * n - (i - 1)) * i / 2).toInt)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      var m = firstLine(1)
      val nums = StdIn.readLine().split("\\s+").map(_.toInt).sorted

      while (m > 0) {
        m -= 1
        val p = StdIn.readLong()
        val (i, j) = calculate(1l * (n + 1) * n / 2 - p, n)
        println(nums(i + j))
      }
    }
  }
}