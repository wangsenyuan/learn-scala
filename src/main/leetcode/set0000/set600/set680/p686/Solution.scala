package set0000.set600.set680.p686

object Solution {
  val F = 31
  val MOD = 1 << 60 + 1
  def repeatedStringMatch(A: String, B: String): Int = {
    if(A.contains(B)) {
      1
    } else if((A + A).contains(B)) {
      2
    } else if(A.length >= B.length) {
      -1
    } else {
      val m = A.length
      val n = B.length

      var ans = find(B, 0, A)
      if(ans > 0) {
        ans
      } else {
        var X = 0L
        var Y = 0L
        var FF = 1L
        def sameHash(i: Int): Boolean = {
          X = (X * F + B(i).toInt) % MOD
          Y = (A(m - 1 - i).toInt * FF + Y) % MOD
          FF = (FF * F) % MOD
          X == Y
        }

        var i = 0
        while(i < m && ans < 0) {
          if(sameHash(i)) {
            ans = find(B, i + 1, A)
          }
          i += 1
        }
        if(ans >= 0) {
          ans + 1
        } else {
          ans
        }
      }
    }
  }

  private def find(B: String, start: Int, A: String): Int = {
    val m = A.length
    var i = start
    var j = 0
    while(i < B.length && B(i) == A(j % m)) {
      i += 1
      j += 1
    }

    if(i == B.length) {
      (j + m - 1) / m
    } else {
      -1
    }
  }
}
