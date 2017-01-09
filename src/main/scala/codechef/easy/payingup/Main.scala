package codechef.easy.payingup

import scala.io.StdIn

/**
  * Created by senyuanwang on 16/8/10.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val T = StdIn.readInt()
    var t = 0
    while (t < T) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val m = line(1)

      val nums = Array.fill(n)(0)
      var i = 0
      while (i < n) {
        nums(i) = StdIn.readInt()
        i += 1
      }

      if (play(m, nums.sorted)) {
        println("Yes")
      } else {
        println("No")
      }
      t += 1
    }
  }

  def play(m: Int, nums: Array[Int]): Boolean = {
    val n = nums.length
    val sums = Array.fill(n + 1)(0)

    var i = 0
    while (i < n) {
      sums(i + 1) = sums(i) + nums(i)
      i += 1
    }

    def doPlay(i: Int, left: Int): Boolean = {
      if (left == 0 || left == sums(n) - sums(i)) {
        true
      } else if (left < nums(i)) {
        false
      } else if (left > sums(n) - sums(i)) {
        false
      } else {
        doPlay(i + 1, left - nums(i)) || doPlay(i + 1, left)
      }
    }

    m > 0 && doPlay(0, m)
  }
}
