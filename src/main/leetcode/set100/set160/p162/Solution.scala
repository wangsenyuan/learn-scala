package set100.set160.p162

object Solution {
  def findPeakElement(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 1) {
      nums(0)
    } else {
      def go(left: Int, right: Int): Int = {
        if (left == right) {
          left
        } else {
          val mid = (left + right) / 2
          if (nums(mid) < nums(mid + 1)) {
            go(mid + 1, right)
          } else {
            go(left, mid)
          }
        }
      }

      go(0, n - 1)
    }
  }
}
