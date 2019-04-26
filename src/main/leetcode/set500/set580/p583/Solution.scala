package set500.set580.p583

object Solution {
  def minDistance(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length
    val dp = Array.fill(m + 1, n + 1)(Int.MaxValue >> 1)

    dp(0)(0) = 0

    for {
      i <- 1 to m
    } {
      dp(i)(0) = i
    }


    for {
      i <- 1 to n
    } {
      dp(0)(i) = i
    }

    for {
      i <- 1 to m
      j <- 1 to n
    } {
      //dp(i)(j) = dp(i-1)(j-1) or dp(i-1)(j) min dp(i)(j-1) + 1
      dp(i)(j) =
        if (word1(i - 1) == word2(j - 1)) {
          dp(i - 1)(j - 1)
        } else {
          (dp(i - 1)(j) min dp(i)(j - 1)) + 1
        }

    }

    dp(m)(n)
  }
}
