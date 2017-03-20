package codechef.easy.donuts

import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/03/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val n = line(0).toLong
    val m = line(1).toInt

    val nums = StdIn.readLine().split("\\s+").map(_.toLong).sorted

    var ans = 0L
    var i = 0
    var j = m - 1

    while (i < j) {
      val x = nums(i)
      val k = j - x //can concat from k

      if (k <= i) {
        ans += j - i
        //concat all
        i = j
      } else if (k == i + 1) {
        ans += x
        i = j
      } else {
        ans += x
        j = k.toInt
        i += 1
      }
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
