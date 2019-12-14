package set1000.set1200.set1220.p1220

object Solution {
  val MOD = 1000000007
  // a -> 0, e -> 1, i -> 2, o -> 3, u -> 4

  def countVowelPermutation(n: Int): Int = {
    val dp = Array.fill(5)(1L)
    val fp = Array.fill(5)(0L)
    var i = 0
    while (i < n - 1) {
      (0 until 5).foreach(j => fp(j) = 0L)
      // a followed by e
      fp(1) += dp(0)
      // e is followed by a or i
      fp(0) = modAdd(fp(0), dp(1))
      fp(2) = modAdd(fp(2), dp(1))

      // Each vowel 'i' may not be followed by another 'i'.
      fp(0) = modAdd(fp(0), dp(2))
      fp(1) = modAdd(fp(1), dp(2))
      fp(3) = modAdd(fp(3), dp(2))
      fp(4) = modAdd(fp(4), dp(2))

      // Each vowel 'o' may only be followed by an 'i' or a 'u'.
      fp(2) = modAdd(fp(2), dp(3))
      fp(4) = modAdd(fp(4), dp(3))

      // Each vowel 'u' may only be followed by an 'a'.
      fp(0) = modAdd(fp(0), dp(4))

      (0 until 5).foreach(j => dp(j) = fp(j))

      i += 1
    }

    val res = dp.reduce(modAdd)
    res.toInt
  }

  private def modAdd(a: Long, b: Long): Long = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }
}
