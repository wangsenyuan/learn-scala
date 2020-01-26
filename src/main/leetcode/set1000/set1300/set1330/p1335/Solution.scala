package set1000.set1300.set1330.p1335

object Solution {
  val INF = 1 << 30

  def minDifficulty(jobDifficulty: Array[Int], d: Int): Int = {
    val n = jobDifficulty.length
    if (d > n) {
      -1
    } else {
      val dp = Array.fill(n + 1)(INF)
      val fp = Array.fill(n + 1)(INF)
      dp(0) = 0
      var i = 0
      while (i < d) {

        var j = 1
        while (j <= n) {
          var k = j - 1
          var x = jobDifficulty(k)
          while (k >= 0) {
            if (dp(k) < INF) {
              fp(j) = fp(j) min (dp(k) + x)
            }
            if (k > 0) {
              x = x max jobDifficulty(k - 1)
            }
            k -= 1
          }
          j += 1
        }

        j = 0
        while (j <= n) {
          dp(j) = fp(j)
          fp(j) = INF
          j += 1
        }

        i += 1
      }

      dp(n)
    }
  }

  def minDifficulty1(jobDifficulty: Array[Int], d: Int): Int = {
    val n = jobDifficulty.length
    val dp = Array.fill(n + 1, d + 1)(INF)
    dp(0)(0) = 0

    var i = 1
    while (i <= d) {
      var j = 1
      while (j <= n) {
        var k = j - 1
        var x = jobDifficulty(j - 1)
        while (k >= 0) {
          if (dp(k)(i - 1) < INF) {
            dp(j)(i) = dp(j)(i) min (dp(k)(i - 1) + x)
          }
          if (k > 0) {
            x = x max jobDifficulty(k - 1)
          }
          k -= 1
        }
        j += 1
      }
      i += 1
    }

    if (dp(n)(d) >= INF) {
      -1
    } else {
      dp(n)(d)
    }
  }
}
