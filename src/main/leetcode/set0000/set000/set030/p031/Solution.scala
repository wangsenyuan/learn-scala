package set0000.set000.set030.p031

object Solution {

  def nextPermutation(nums: Array[Int]): Unit = {
    val n = nums.length
    if (n > 1) {
      var i = n - 2
      while (i >= 0 && nums(i) >= nums(i + 1)) {
        i -= 1
      }
      // i is at the first place (from right to left) that, nums(i) < nums(i + 1)
      if (i >= 0) {
        var j = i + 1
        var k = j
        while (k < n) {
          if (nums(k) > nums(i) && nums(k) <= nums(j)) {
            j = k
          }
          k += 1
        }
        // k have to be valid
        swap(nums, i, j)
        swapRange(nums, i + 1, n - 1)
      } else {
        swapRange(nums, 0, n - 1)
      }
    }
  }

  private def swapRange(nums: Array[Int], start: Int, end: Int) = {
    var i = start
    var j = end
    while(i < j) {
      swap(nums, i, j)
      i += 1
      j -= 1
    }
  }

  private def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }
}
