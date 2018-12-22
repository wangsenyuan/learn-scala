package set000.set080.p088

object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var p = m + n - 1
    var i = m - 1
    var j = n - 1
    while (i >= 0) {
      if (j >= 0 && nums2(j) >= nums1(i)) {
        nums1(p) = nums2(j)
        j -= 1
        p -= 1
      } else {
        nums1(p) = nums1(i)
        i -= 1
        p -= 1
      }
    }
    while (j >= 0) {
      nums1(p) = nums2(j)
      j -= 1
      p -= 1
    }
  }
}
