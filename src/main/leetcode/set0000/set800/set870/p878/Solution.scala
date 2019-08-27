package set0000.set800.set870.p878

object Solution {
  val MOD = 1000000007

  def nthMagicalNumber(N: Int, A: Int, B: Int): Int = {
    if (A > B) {
      nthMagicalNumber(N, B, A)
    } else if (B % A == 0) {
      ((N.toLong * A) % MOD).toInt
    } else {
      val g = gcd(A, B)
      val a = A / g
      val b = B / g

      def count(n1: Int): Int = {
        val x = n1.toLong * a
        val n2 = x / b
        val r = n1 + n2 - n2 / a
        r.toInt
      }

      var left = 1
      var right = N
      while (left < right) {
        val mid = (left + right) / 2
        val m = count(mid)
        if (m >= N) {
          right = mid
        } else {
          left = mid + 1
        }
      }

      val cnt = count(right)
      if (cnt == N) {
        ((A.toLong * right) % MOD).toInt
      } else {
        // cnt > N
        val x = right.toLong * a

        val y = (x / b) * B

        (y % MOD).toInt
      }
    }
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
