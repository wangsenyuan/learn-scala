package codechef.easy.mmsum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/03/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    val left = Array.fill(n)(0L)

    var i = 0
    while (i < n) {
      if (i == 0 || left(i - 1) < 0) {
        left(i) = nums(i)
      } else {
        left(i) = left(i - 1) + nums(i)
      }
      i += 1
    }

    val right = Array.fill(n)(0L)
    i = n - 1
    while (i >= 0) {
      if (i == n - 1 || right(i + 1) < 0) {
        right(i) = nums(i)
      } else {
        right(i) = right(i + 1) + nums(i)
      }
      i -= 1
    }

    var ans = Long.MinValue
    i = 0
    while (i < n) {
      val a = left(i) + right(i) - nums(i) //include i
      ans = ans max a
      if (nums(i) < 0) {
        //only remove negative may get a bigger one
        val b = if (i == 0) 0 else left(i - 1)
        val c = if (i == n - 1) 0 else right(i + 1)
        ans = ans max (b + c)
      }

      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
