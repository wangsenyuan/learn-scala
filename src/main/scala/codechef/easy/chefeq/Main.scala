package codechef.easy.chefeq

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/18.
  */
object Main {

  def countMostFreq(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var res = 1
    var i = 1
    var j = 0
    while (i <= sorted.length) {
      if (i == sorted.length || sorted(i) != sorted(i - 1)) {
        res = res max (i - j)
        j = i
      }
      i += 1
    }

    res
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      val cnt = countMostFreq(nums)

      println(n - cnt)

      t -= 1
    }
  }
}
