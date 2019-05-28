package set700.set710.p717

object Solution {
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    val n = bits.length
    val dp = Array.ofDim[Boolean](n + 1)
    dp(0) = true

    var i = 0
    while(i < n) {
      if(bits(i) == 1) {
        if(i > 0 && bits(i-1) == 1) {
          dp(i+1) = dp(i - 1)
        }
      } else if(bits(i) == 0) {
        dp(i+1) = dp(i)
        if(i > 0 && bits(i - 1) == 1) {
          dp(i+1) ||= dp(i-1)
        }
      }

      i += 1
    }

    dp(n) && dp(n - 1)
  }
}
