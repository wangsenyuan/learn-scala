package set1000.set1200.set1260.p1262

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def maxSumDivThree(nums: Array[Int]): Int = {
    val one = Array.fill(2)(Int.MaxValue)
    val two = Array.fill(2)(Int.MaxValue)
    var best = 0
    var sum = 0
    for {
      num <- nums
    } {
      sum += num
      val r = sum % 3

      if (num % 3 == 1) {
        update(one, num)
      } else if (num % 3 == 2) {
        update(two, num)
      }

      if (r == 0) {
        best = sum
      } else if (r == 1) {
        if (one(0) < Int.MaxValue) {
          best = best max (sum - one(0))
        }

        if (two(1) < Int.MaxValue) {
          best = best max (sum - two(0) - two(1))
        }
      } else {
        if (one(1) < Int.MaxValue) {
          best = best max (sum - one(0) - one(1))
        }
        if (two(0) < Int.MaxValue) {
          best = best max (sum - two(0))
        }
      }
    }
    best
  }

  private def update(arr: Array[Int], num: Int): Unit = {
    if (num < arr(0)) {
      arr(1) = arr(0)
      arr(0) = num
    } else if (num < arr(1)) {
      arr(1) = num
    }
  }

  def maxSumDivThree1(nums: Array[Int]): Int = {
    Sorting.quickSort(nums)
    val n = nums.length
    val sums = Array.fill(3, n)(-1)
    val idx = Array.ofDim[Int](3)
    var i = n - 1
    while (i >= 0) {
      val r = nums(i) % 3
      sums(r)(idx(r)) = nums(i)
      idx(r) += 1
      i -= 1
    }

    var res = 0
    i = 0
    while (i < idx(0)) {
      res += sums(0)(i)
      i += 1
    }

    i = 0
    while (i + 6 <= idx(1)) {
      res += sums(1)(i)
      res += sums(1)(i + 1)
      res += sums(1)(i + 2)
      i += 3
    }

    var j = 0
    while (j + 6 <= idx(2)) {
      res += sums(2)(j)
      res += sums(2)(j + 1)
      res += sums(2)(j + 2)
      j += 3
    }

    val buf = ArrayBuffer.empty[Int]
    while (i < idx(1)) {
      buf += sums(1)(i)
      i += 1
    }

    while (j < idx(2)) {
      buf += sums(2)(j)
      j += 1
    }
    res + maxSum(buf.toArray)
  }

  private def maxSum(arr: Array[Int]): Int = {
    //arr.length <= 6
    val n = arr.length
    val N = 1 << n
    var best = 0
    var state = 1
    while (state < N) {
      var sum = 0
      var i = 0
      while (i < n) {
        if ((state & (1 << i)) > 0) {
          sum += arr(i)
        }
        i += 1
      }
      if (sum % 3 == 0) {
        best = best max sum
      }
      state += 1
    }
    best
  }
}
