package p300

import scalaz.syntax.std.VectorOps

/**
  * Created by senyuanwang on 2016/10/22.
  */
object App {

  def lengthOfLIS(nums: Array[Int]): Int = {

    def replace(lis: Vector[Int], x: Int): Vector[Int] = {
      var i = 0
      var j = lis.length - 1
      while (i <= j) {
        val k = i + (j - i) / 2
        if (lis(k) >= x) {
          j = k - 1
        } else {
          i = k + 1
        }
      }

      lis.take(j + 1) ++ Vector(x) ++ lis.drop(j + 2)
    }

    def go(lis: Vector[Int], i: Int): Int = {
      if (i == nums.length) {
        lis.size
      } else if (nums(i) >= lis.last) {
        go(lis :+ nums(i), i + 1)
      } else if (nums(i) <= lis.head) {
        go(nums(i) +: lis.tail, i + 1)
      } else {
        go(replace(lis, nums(i)), i + 1)
      }
    }

    go(Vector(nums(0)), 1)
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(10, 9, 2, 5, 3, 7, 101, 18)
    val ans = lengthOfLIS(nums)
    println(ans)
  }
}
