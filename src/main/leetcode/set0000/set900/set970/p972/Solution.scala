package set0000.set900.set970.p972

object Solution {
  def isRationalEqual(S: String, T: String): Boolean = {
    val a = Fraction(S)
    val b = Fraction(T)

    a.n == b.n && a.d == b.d
  }


  case class Fraction(n: Long, d: Long) {
    def add(that: Fraction): Fraction = {
      val x = this.n * that.d + this.d * that.n
      val y = this.d * that.d
      val g = gcd(x, y)
      Fraction(x / g, y / g)
    }
  }

  object Fraction {
    def apply(str: String): Fraction = {
      val n = str.length
      var state = 0
      var ans = Fraction(0, 1)
      var decimalSize = 0
      var j = 0
      var i = 0
      while (i <= n) {
        if (i == n || str(i) == '.' || str(i) == ')' || str(i) == '(') {
          state += 1
          if (j + 1 <= i) {
            val x = str.substring(j, i).toLong
            val sz = i - j
            if (state == 1) {
              ans = ans.add(Fraction(x, 1))
            } else if (state == 2) {
              val y = Math.pow(10, sz).toLong
              ans = ans.add(Fraction(x, y))
              decimalSize = sz
            } else {
              var deno = Math.pow(10, decimalSize).toLong
              deno *= (Math.pow(10, sz).toLong - 1)
              ans = ans.add(Fraction(x, deno))
            }


          }
          j = i + 1
        }
        i += 1
      }

      ans
    }
  }

  private def gcd(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
