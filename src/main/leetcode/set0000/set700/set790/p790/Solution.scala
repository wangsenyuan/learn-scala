package set0000.set700.set790.p790

object Solution {

  val MOD = (1e9 + 7) toLong

  def numTilings(N: Int): Int = {
    // f(n) = f(n - 1) + f(n-2) + f(n-3) * 2
    if(N == 1) {
      1
    } else if(N == 2) {
      2
    } else {
      // n - 3
      var a = 1L
      // n - 2
      var b = 1L
      // n - 1
      var c = 2L
      var i = 3L
      while(i <= N) {
        val x = (2 * c + a) % MOD
        a = b
        b = c
        c = x
        i += 1
      }

      c.toInt
    }
  }
}
