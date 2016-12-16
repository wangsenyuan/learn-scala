package codechef.chefzot

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    println(findMaxNonZeroProductSubArrayLength(nums))
  }

  def findMaxNonZeroProductSubArrayLength(nums: Array[Int]): Int = {
    def go(i: Int, l: Int, r: Int): Int = {
      if (i == nums.length) {
        r
      } else if (nums(i) != 0) {
        go(i + 1, l + 1, (l + 1) max r)
      } else {
        go(i + 1, 0, r)
      }
    }

    go(0, 0, 0)
  }
}
