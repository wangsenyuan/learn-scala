package set700.set760.p762

object Solution {
  def countPrimeSetBits(L: Int, R: Int): Int = {
    val primes = Array.fill(31)(true)
    primes(0) = false
    primes(1) = false
    var x = 2
    while(x < 30) {
      if(primes(x)) {
        var y = x * x
        while(y < 30) {
          primes(y) = false
          y += x
        }
      }

      x += 1
    }

    var ans = 0
    var num = L
    while(num <= R) {
      val cnt = Integer.bitCount(num)
      if(primes(cnt)) {
        ans += 1
      }
      num += 1
    }

    ans
  }
}
