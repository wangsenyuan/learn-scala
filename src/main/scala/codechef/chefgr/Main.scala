package codechef.chefgr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 26/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1

      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val m = firstLine(1)

      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      val mx = nums.max

      val totalDiff = nums.map(mx - _).sum

      if (totalDiff <= m && (m - totalDiff) % n == 0) {
        println("Yes")
      } else {
        println("No")
      }
    }
  }
}
