package set1000.set1100.set1190.p1191

object Solution {
  val MOD = 1000000007

  def kConcatenationMaxSum(arr: Array[Int], k: Int): Int = {
    if (k == 1) {
      findBestSum(arr)
    } else {
      val n = arr.length
      val dp = Array.ofDim[Long](n)
      val fp = Array.ofDim[Long](n)
      var i = 0
      var sum = 0
      while (i < n) {
        sum += arr(i)
        dp(i) = 0 max sum
        if (i > 0) {
          dp(i) = dp(i) max dp(i - 1)
        }
        i += 1
      }

      sum = 0
      i = n - 1
      while (i >= 0) {
        sum += arr(i)
        fp(i) = 0 max sum
        if (i < n - 1) {
          fp(i) = fp(i) max fp(i + 1)
        }
        i -= 1
      }

      var best = findBestSum(arr ++ arr).toLong
      if (sum < 0) {
        // can't repeat, as repetition will cause the sum goes lower
        best.toInt
      } else {
        best = best max (sum.toLong * k)
        best = best max caseOne(sum, k, dp)
        best = best max caseOne(sum, k, fp)
        best = best max caseTwo(sum, k, fp, dp)
        (best % MOD).toInt
      }
    }
  }

  private def caseOne(sum: Int, k: Int, dp: Array[Long]): Long = {
    val ans = (sum.toLong * (k - 1))
    ans + dp.max
  }

  private def caseTwo(sum: Int, k: Int, fp: Array[Long], dp: Array[Long]): Long = {
    val ans = sum.toLong * (k - 2)
    ans + fp.max + dp.max
  }

  private def findBestSum(arr: Array[Int]): Int = {
    var best = 0
    var sum = 0
    var i = 0
    while (i < arr.length) {
      sum += arr(i)
      best = best max sum
      if (sum < 0) {
        sum = 0
      }
      i += 1
    }
    best % MOD
  }
}
