package set0000.set500.set540.p546

object Solution {
  def removeBoxes(boxes: Array[Int]): Int = {
    val n = boxes.length
    val dp = Array.ofDim[Int](n, n, n)

    for {
      i <- 0 until n
      k <- 0 to i
    } {
      dp(i)(i)(k) = (k + 1) * (k + 1)
    }

    for {
      l <- 1 until n
      j <- l until n
      i = j - l
      k <- 0 to i
    } {
      //dp(i)(j)(k)
      var res = (k + 1) * (k + 1) + dp(i + 1)(j)(0)
      for {
        u <- i + 1 to j
        if (boxes(u) == boxes(i))
      } {
        res = res max (dp(i + 1)(u - 1)(0) + dp(u)(j)(k + 1))
      }
      dp(i)(j)(k) = res
    }

    if (n == 0) {
      0
    } else {
      dp(0)(n - 1)(0)
    }
  }
}
