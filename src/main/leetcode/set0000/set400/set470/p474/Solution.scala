package set0000.set400.set470.p474

object Solution {
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for {
      s <- strs
      (a, b) = convert(s)
    } {
      for {
        i <- m to a by -1
        j <- n to b by -1
      } {
        dp(i)(j) = dp(i)(j) max (1 + dp(i - a)(j - b))
      }
    }
    dp(m)(n)
  }

  private def convert(s: String): (Int, Int) = {
    val a = s.count(_ == '0')
    (a, s.length - a)
  }
}
