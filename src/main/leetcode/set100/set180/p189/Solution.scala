package set100.set180.p189

/**
  * Created by senyuanwang on 15/2/26.
  */
object Solution {
  def rotate(nums: Array[Int], k: Int): Unit = {
    val n = nums.length
    if (n > 0) {
      if (k >= n) {
        rotate(nums, k % n)
      } else if (k > 0) {
        swap(nums, 0, n)
        swap(nums, 0, k)
        swap(nums, k, n)
      }
    }
  }

  private def swap(nums: Array[Int], left: Int, right: Int): Unit = {
    var i = left
    var j = right - 1
    while (i < j) {
      nums(i) ^= nums(j)
      nums(j) ^= nums(i)
      nums(i) ^= nums(j)
      i += 1
      j -= 1
    }
  }
}
