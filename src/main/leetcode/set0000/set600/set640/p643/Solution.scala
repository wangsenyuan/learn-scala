package set0000.set600.set640.p643

object Solution {
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    var sum = 0
    var i = 0
    while(i < k) {
      sum += nums(i)
      i += 1
    }

    var best = sum
    while(i < nums.length) {
      sum += nums(i) - nums(i-k)

      best = best max sum
      i += 1
    }

    best.toDouble / k
  }
}
