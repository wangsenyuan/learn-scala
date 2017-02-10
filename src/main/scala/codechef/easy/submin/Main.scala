package codechef.easy.submin

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    val mins = Array.fill(n * n)(0)

    var i = 0
    while (i < n) {
      mins(i * n + i) = nums(i)
      i += 1
    }

    i = 0
    while (i < n) {
      var j = i + 1
      while (j < n) {
        mins(i * n + j) = mins(i * n + j - 1) min nums(j)
        j += 1
      }

      i += 1
    }

    val sorted = mins.sorted
    var q = StdIn.readInt()
    while (q > 0) {
      val k = StdIn.readInt()

      val a = search(sorted.length, sorted(_) > k)
      val b = search(sorted.length, sorted(_) >= k)

      println(a - b)

      q -= 1
    }
  }

  def search(n: Int, f: Int => Boolean): Int = {
    var i = 0
    var j = n
    while (i < j) {
      val k = i + (j - i) / 2
      if (f(k)) {
        j = k
      } else {
        i = k + 1
      }
    }
    i
  }
}
