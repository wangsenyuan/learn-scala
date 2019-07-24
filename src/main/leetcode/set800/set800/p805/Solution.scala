package set800.set800.p805

object Solution {

  def splitArraySameAverage(A: Array[Int]): Boolean = {
    val sum = A.sum
    val n = A.length

    val dp = Array.ofDim[Boolean](sum + 1, n + 1)
    dp(0)(0) = true

    var i = 1
    while (i <= n) {
      val x = A(i - 1)
      var num = sum
      while (num >= x) {
        var j = i - 1
        while (j >= 0) {
          if (dp(num - x)(j)) {
            dp(num)(j + 1) = true
          }
          j -= 1
        }
        num -= 1
      }

      while (num + x <= sum) {


        num += 1
      }

      i += 1
    }

    var L = 1
    while (L < n) {
      val s1 = (L * sum) / n
      if (s1 * n == L * sum) {
        // a candidate
        if (dp(s1)(L)) {
          return true
        }
      }
      L += 1
    }

    return false
  }
}
