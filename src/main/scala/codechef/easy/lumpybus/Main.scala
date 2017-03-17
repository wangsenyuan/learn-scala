package codechef.easy.lumpybus

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/03/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val n = line(0).toInt
    var p = line(1).toLong
    var q = line(2).toLong

    val nums = StdIn.readLine().split("\\s+").map(_.toLong).sorted
    var ans = 0
    var i = 0
    while (i < n) {
      val num = nums(i)

      val x = (num / 2) min q
      //use 2 first
      val y = num - 2 * x
      if (y > p) {
        //can't satisfy it
      } else {
        ans += 1
        q -= x
        p -= y
      }
      i += 1
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
