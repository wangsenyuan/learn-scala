package set0000.set400.set490.p496

import scala.collection.mutable

object Solution {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val n = nums2.length
    val right = Array.fill(n)(-1)
    val stack = Array.fill(n)(-1)
    var p = 0
    var i = 0

    val ii = mutable.Map.empty[Int, Int]
    while (i < n) {
      while (p > 0 && nums2(stack(p - 1)) < nums2(i)) {
        right(stack(p - 1)) = i
        p -= 1
      }

      stack(p) = i
      p += 1

      ii(nums2(i)) = i

      i += 1
    }

    val m = nums1.length
    val res = Array.fill(m)(-1)

    var j = 0
    while (j < m) {
      val i = ii(nums1(j))
      if (right(i) >= 0) {
        res(j) = nums2(right(i))
      }
      j += 1
    }

    res
  }
}
