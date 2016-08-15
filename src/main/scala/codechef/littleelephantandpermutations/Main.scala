package codechef.littleelephantandpermutations

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/15/16.
  */
object Main {

  def at(len: Int, f: Int => Boolean): Int = {
    var i = 0
    var at = -1
    while (i < len) {
      if (f(i)) {
        at = i
      }
      i += 1
    }

    at
  }

  def maxAt(nums: Vector[Int]): Int = {
    var a = Int.MinValue
    at(nums.size, i => {
      if (nums(i) > a) {
        a = nums(i)
        true
      } else {
        false
      }
    })
  }

  def minAt(nums: Vector[Int]): Int = {
    var a = Int.MaxValue
    at(nums.size, i => {
      if (nums(i) < a) {
        a = nums(i)
        true
      } else {
        false
      }
    })
  }

  def notPerfect(nums: Vector[Int]): Boolean = {
    if (nums.size <= 1) {
      return false;
    }

    val mid = nums.size / 2

    val (first, second) = nums.splitAt(mid)
    val a = maxAt(first)
    val b = minAt(second) + first.size
    if (nums(a) > nums(b) && a + 1 < b) {
      true
    } else {
      notPerfect(first) || notPerfect(second)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val line = StdIn.readLine()
      val nums = line.split("\\s+").map(_.toInt).toVector

      val r = notPerfect(nums)
      if (r) {
        println("NO")
      } else {
        println("YES")
      }
      t -= 1
    }
  }
}
