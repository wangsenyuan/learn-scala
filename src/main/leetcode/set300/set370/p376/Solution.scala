package set300.set370.p376

object Solution {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 0) {
      0
    } else {
      val up = Array.ofDim[Int](n)
      val down = Array.ofDim[Int](n)
      up(0) = 1
      down(0) = 1
      var i = 1
      while (i < n) {
        if (nums(i) > nums(i - 1)) {
          up(i) = down(i - 1) + 1
          down(i) = down(i - 1)
        } else if (nums(i) < nums(i - 1)) {
          up(i) = up(i - 1)
          down(i) = up(i - 1) + 1
        } else {
          up(i) = up(i - 1)
          down(i) = down(i - 1)
        }

        i += 1
      }
      up(n - 1) max down(n - 1)
    }
  }
}
