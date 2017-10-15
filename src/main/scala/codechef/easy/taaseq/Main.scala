package codechef.easy.taaseq

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val n = StdIn.readLine()
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    val a = play1(nums)
    val b = play2(nums)
    val c = play3(nums)
    val can = Array(a, b, c).filter(_ >= 0)

    if (can.isEmpty) {
      println(-1)
    } else {
      println(can.min)
    }
  }

  def play1(nums: Array[Long]): Long = {
    if (isProgressive(nums.tail)) {
      nums(0)
    } else {
      -1
    }
  }

  def play2(nums: Array[Long]): Long = {
    if (isProgressive(nums(0) +: nums.drop(2))) {
      nums(1)
    } else {
      -1
    }
  }

  def play3(nums: Array[Long]): Long = {
    val diff = nums(1) - nums(0)
    var i = 2
    while (i < nums.size && nums(i) == nums(i - 1) + diff) {
      i += 1
    }
    if (i == nums.size) {
      nums(0) min nums(i - 1)
    } else {
      if (isProgressive(nums.take(i) ++ nums.drop(i + 1))) {
        nums(i)
      } else {
        -1
      }
    }
  }

  def isProgressive(nums: Array[Long]): Boolean = {
    if (nums.size == 1) {
      true
    } else {
      val diff = nums(1) - nums(0)
      var i = 2
      while (i < nums.size && nums(i) == nums(i - 1) + diff) {
        i += 1
      }
      i == nums.size
    }
  }
}
