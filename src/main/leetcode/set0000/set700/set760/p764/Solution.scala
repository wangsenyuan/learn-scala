package set0000.set700.set760.p764

object Solution {
  def orderOfLargestPlusSign(N: Int, mines: Array[Array[Int]]): Int = {
    val grid = Array.fill(N, N)(1)
    mines.foreach(mine => {
      val x = mine(0)
      val y = mine(1)
      grid(x)(y) = 0
    })

    val dp = Array.ofDim[Int](N, N, 4)

    var i = 0
    while (i < N) {
      var j = 0
      while (j < N) {
        if (grid(i)(j) == 1) {
          dp(i)(j)(0) = 1
          dp(i)(j)(1) = 1
          if (i > 0) {
            dp(i)(j)(0) += dp(i - 1)(j)(0)
          }
          if (j > 0) {
            dp(i)(j)(1) += dp(i)(j - 1)(1)
          }
        }

        j += 1
      }

      i += 1
    }

    i = N - 1
    while(i >= 0) {
      var j = N - 1
      while(j >= 0) {
        if(grid(i)(j) == 1) {
          dp(i)(j)(2) = 1
          dp(i)(j)(3) = 1
          if(j < N - 1) {
            dp(i)(j)(2) += dp(i)(j+1)(2)
          }
          if(i < N - 1) {
            dp(i)(j)(3) += dp(i+1)(j)(3)
          }
        }

        j -= 1
      }

      i -= 1
    }
    var res = 0
    i = 0
    while(i < N) {
      var j = 0
      while(j < N) {
        if(grid(i)(j) == 1) {
          grid(i)(j) = dp(i)(j)(0) min dp(i)(j)(1) min dp(i)(j)(2) min dp(i)(j)(3)
          res = res max grid(i)(j)
        }
        j += 1
      }

      i += 1
    }

    res
  }
}
