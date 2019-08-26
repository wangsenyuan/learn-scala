package set0000.set000.set080.p080

object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    val n = nums.length
    var j = 0
    var k = 0

    for {
      i <- 1 to n
      if (i == n || nums(i) > nums(i - 1))
    } {
      nums(j) = nums(i - 1)
      j += 1
      if (i - k > 1) {
        nums(j) = nums(i - 1)
        j += 1
      }
      k = i
    }

    j
  }
}
