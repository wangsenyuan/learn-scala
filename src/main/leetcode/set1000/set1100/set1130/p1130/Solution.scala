package set1000.set1100.set1130.p1130

object Solution {
  val INF = 1 << 30

  def mctFromLeafValues(arr: Array[Int]): Int = {
    val n = arr.length

    val dp = Array.ofDim[Int](n, n + 1)

    for {
      i <- 0 until n
    } {
      for {
        j <- 0 to n
      } {
        dp(i)(j) = INF
      }
      dp(i)(1) = 0
    }

    val fp = Array.ofDim[Int](n, n + 1)

    for {
      i <- 0 until n
    } {
      fp(i)(1) = arr(i)
    }

    for {
      k <- 2 to n
    } {
      for {
        i <- 0 to n - k
      } {
        fp(i)(k) = fp(i)(k - 1) max arr(i + k - 1)
      }
    }

    for {
      k <- 2 to n
    } {
      for {
        i <- 0 to n - k
        x <- 1 until k
      } {
        // dp(i)(k) = dp(i)(x) + dp(i + x)(k - x) + min(i)(x) * min(i + x)(k - x)
        val y = dp(i)(x) + dp(i + x)(k - x) + fp(i)(x) * fp(i + x)(k - x)
        dp(i)(k) = dp(i)(k) min y
      }
    }

    dp(0)(n)
  }
}
