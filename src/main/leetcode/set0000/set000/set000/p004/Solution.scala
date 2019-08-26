package set0000.set000.set000.p004

object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val m = nums1.length
    val n = nums2.length

    val k = m + n
    if (k % 2 == 1) {
      chop(nums1, nums2, k - k / 2 - 1)
    } else {
      val x = chop(nums1, nums2, k - k / 2)
      val y = chop(nums1, nums2, k - k / 2 - 1)
      (x + y) / 2
    }
  }

  private def chop(nums1: Array[Int], nums2: Array[Int], count: Int): Double = {
    var m = nums1.length
    var n = nums2.length
    var left = count
    while (left > 0 && m > 0 && n > 0) {
      val a = 1 max (left / 2 min m / 2)
      val b = 1 max (left / 2 min n / 2)
      val i = m - a
      val j = n - b
      if (nums1(i) < nums2(j)) {
        n = j
        left -= b
      } else {
        m = i
        left -= a
      }
    }

    if (m == 0 && n == 0) {
      // all removed, can't be true
      0
    } else if (m == 0) {
      nums2(n - 1 - left)
    } else if (n == 0) {
      nums1(m - 1 - left)
    } else {
      nums1(m - 1) max nums2(n - 1)
    }
  }
}
