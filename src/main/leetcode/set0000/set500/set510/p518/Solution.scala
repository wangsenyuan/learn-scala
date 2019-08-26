package set0000.set500.set510.p518

object Solution {
  def change1(amount: Int, coins: Array[Int]): Int = {
    val n = coins.length
    if (amount == 0) {
      1
    } else if (n == 0) {
      0
    } else {
      val dp = Array.fill(amount + 1, n)(0)

      dp(0)(0) = 1

      for {
        x <- 0 until amount
        i <- 0 until n
        j <- i until n
        if (x + coins(j) <= amount)
      } {
        dp(x + coins(j))(j) += dp(x)(i)
      }

      dp(amount).sum
    }
  }

  def change2(amount: Int, coins: Array[Int]): Int = {
    val n = coins.length
    if (amount == 0) {
      1
    } else if (n == 0) {
      0
    } else {
      val dp = Array.fill(amount + 1)(0)
      val fp = Array.fill(amount + 1)(0)
      dp(0) = 1
      for {
        i <- 0 until n
      } {
        for {
          x <- 0 to amount
        } {
          fp(x) = dp(x)
        }
        for {
          x <- 0 until amount
        } {
          var y = x + coins(i)
          while (y <= amount) {
            dp(y) += fp(x)
            y += coins(i)
          }
        }
      }
      dp(amount)
    }
  }

  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = Array.ofDim[Int](amount + 1)
    dp(0) = 1
    for {
      coin <- coins
      x <- coin to amount
    } {
      dp(x) += dp(x - coin)
    }
    dp(amount)
  }
}
