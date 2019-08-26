package set0000.set700.set710.p713

object Solution {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    var res = 0
    var prod = 1
    var j = 0
    var i = 0
    while(i < n) {
      prod *= nums(i)
      while(j <= i && prod >= k) {
        prod /= nums(j)
        j += 1
      }
      res += i - j + 1
      i += 1
    }
    res
  }
}
