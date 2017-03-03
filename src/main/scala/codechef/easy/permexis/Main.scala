package codechef.easy.permexis

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/03/2017.
  */
object Main {

  def canPermute(nums: Array[Long], n: Int) = {
    val sorted = nums.sorted

    var i = 1
    while (i < n && nums(i) - nums(i - 1) <= 1) {
      i += 1
    }

    i == n
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toLong)
        val res = canPermute(nums, n)
        if (res) {
          println("YES")
        } else {
          println("NO")
        }
    }
  }
}
