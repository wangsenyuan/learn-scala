package set300.set320.p324

import scala.util.Sorting

object Solution {
  def isWiggle(nums: Array[Int]) = {
    val n = nums.length
    var i = 0
    var can = true
    while (i < n - 1 && can) {
      if (i == 0) {
        can = nums(0) < nums(1)
      } else if (i % 2 == 1) {
        can = nums(i) > nums(i - 1) && nums(i) > nums(i + 1)
      } else {
        can = nums(i) < nums(i - 1) && nums(i) < nums(i + 1)
      }
      i += 1
    }
    can
  }

  def wiggleSort(nums: Array[Int]): Unit = {
    val n = nums.length

    val A = Array.fill(n)(0)
    Array.copy(nums, 0, A, 0, n)
    Sorting.quickSort(A)

    var i = n / 2
    if (n % 2 == 0) {
      i -= 1
    }
    var k = 0
    while (i >= 0) {
      nums(2 * k) = A(i)
      k += 1
      i -= 1
    }

    var j = n / 2
    if (n % 2 == 1) {
      j += 1
    }

    val median =
      (if (n % 2 == 0) {
        (A(n / 2 - 1).toDouble + A(n / 2).toDouble) / 2
      } else {
        A(n / 2).toDouble
      }).toInt

    //need to move medians to the last position of right if any
    var cnt = 0
    while (j < n && A(j) == median) {
      j += 1
      cnt += 1
    }

    k = 0
    while (j < n) {
      nums(2 * k + 1) = A(j)
      k += 1
      j += 1
    }
    while (cnt > 0) {
      nums(2 * k + 1) = median
      k += 1
      cnt -= 1
    }
  }
}
