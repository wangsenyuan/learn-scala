package set300.set320.p321

import scala.annotation.tailrec

/**
  * Created by wangsenyuan on 05/11/2016.
  */
object Solution2 {

  def main(args: Array[String]): Unit = {
    val nums1: Array[Int] = Array(3, 4, 6, 5)
    val nums2: Array[Int] = Array(9, 1, 2, 5, 8, 3)

    println(maxNumber(nums1, nums2, 5).mkString(" "))
  }

  def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
    val n = nums1.length
    val m = nums2.length

    var i = 0 max (k - m)
    var ans = Array.fill(k)(0)
    while (i <= k && i <= n) {
      val a = maxNum(nums1, i)
      val b = maxNum(nums2, k - i)
      val c = merge(a, b, k)
      if (greater(c, 0, ans, 0)) {
        ans = c
      }
      i += 1
    }

    ans
  }

  private def merge(a: Array[Int], b: Array[Int], k: Int): Array[Int] = {
    var i = 0
    var j = 0
    val c = Array.fill(k)(0)
    var r = 0
    while (r < k) {
      if (greater(a, i, b, j)) {
        c(r) = a(i)
        i += 1
      } else {
        c(r) = b(j)
        j += 1
      }
      r += 1
    }

    c
  }

  @tailrec
  private final def greater(a: Array[Int], i: Int, b: Array[Int], j: Int): Boolean = {
    if (i == a.length) {
      false
    } else if (j == b.length) {
      true
    } else if (a(i) == b(j)) {
      greater(a, i + 1, b, j + 1)
    } else {
      a(i) > b(j)
    }
  }

  private def maxNum(nums: Array[Int], k: Int): Array[Int] = {
    val ans = Array.fill(k)(0)
    var i = 0
    var j = 0
    val n = nums.length
    while (i < n) {
      while (n - i > k - i && j > 0 && ans(j - 1) < nums(i)) {
        j -= 1
      }

      if (j < k) {
        ans(j) = nums(i)
        j += 1
      }
      i += 1
    }
    ans
  }
}
