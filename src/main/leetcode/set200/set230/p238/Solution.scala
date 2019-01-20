package set200.set230.p238

object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val left = Array.fill(n)(1)
    left(0) = nums(0)
    var i = 1
    while (i < n) {
      left(i) = nums(i) * left(i - 1)
      i += 1
    }
    val res = Array.fill(n)(1)
    var prod = 1
    i = n - 1
    while (i > 0) {
      res(i) = prod * left(i - 1)
      prod *= nums(i)
      i -= 1
    }
    res(0) = prod
    res
  }
}
