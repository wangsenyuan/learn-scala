package set0000.set600.set670.p670

object Solution {
  def maximumSwap(num: Int): Int = {
    val digits = Array.ofDim[Int](10)
    var n = 0
    var number = num
    while(number > 0) {
      digits(n) = number % 10
      number /= 10
      n += 1
    }

    reverse(digits, n)

    if(n <= 1) {
      num
    } else {
      //find largest number in the array, prefer right
      // dp(i) = right-most number that is just larger than digits(i)
      val dp = Array.ofDim[Int](n)
      dp(n - 1) = n - 1
      var i = n - 2
      while(i >= 0) {
        dp(i) = dp(i+1)
        if(digits(i) > digits(dp(i))) {
          dp(i) = i
        }

        i -= 1
      }

      i = 0
      while(i < n && digits(dp(i)) == digits(i)) {
        i += 1
      }

      if(i == n) {
        num
      } else {
        val j = dp(i)
        digits(i) = digits(i) ^ digits(j)
        digits(j) = digits(i) ^ digits(j)
        digits(i) = digits(i) ^ digits(j)
        var res = 0
        i = 0
        while(i < n) {
          res = res * 10 + digits(i)
          i += 1
        }
        res
      }
    }

  }

  private def reverse(nums: Array[Int], n: Int): Unit = {
    var i = 0
    var j = n - 1
    while(i < j) {
      nums(i) = nums(i) ^ nums(j)
      nums(j) = nums(i) ^ nums(j)
      nums(i) = nums(i) ^ nums(j)
      i += 1
      j -= 1
    }
  }
}
