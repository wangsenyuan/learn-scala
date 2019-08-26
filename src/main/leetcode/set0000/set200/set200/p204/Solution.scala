package set0000.set200.set200.p204


object Solution {

  import java.math.BigInteger

  def countPrimes1(n: Int): Int = {
    var res = 0

    for {
      x <- 2 until n
      y = new BigInteger(x.toString)
      if y.isProbablePrime(5)
    } {
      res += 1
    }
    res
  }

  def countPrimes(n: Int): Int = {
    val bs = new java.util.BitSet()

    var res = 0

    var x = 2
    while (x < n) {
      val y = bs.nextClearBit(x)

      if (y < n) {
        res += 1
        for {
          z <- 2 * y until n by y
        } {
          bs.set(z)
        }
      }

      x = y + 1
    }
    res
  }
}
