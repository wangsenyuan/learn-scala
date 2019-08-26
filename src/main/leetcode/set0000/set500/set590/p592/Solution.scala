package set0000.set500.set590.p592

object Solution {
  def fractionAddition(expression: String): String = {
    val n = expression.length

    def readFraction(start: Int): (F, Int) = {
      var sign = 1
      var i = start
      if(expression(i) == '+') {
        i += 1
      } else if(expression(i) == '-') {
        sign = -1
        i += 1
      }

      var num = 0
      while(expression(i) != '/') {
        num = num * 10 + expression(i) - '0'
        i += 1
      }
      var deno = 0
      i += 1
      while(i < n && expression(i).isDigit) {
        deno = deno * 10 + expression(i) - '0'
        i += 1
      }
      (F(sign * num, deno), i)
    }

    var res = F(0, 1)
    var end = 0
    while(end < n) {
      val (f, i) = readFraction(end)
      res += f
      end = i
    }

    res.toString
  }

  case class F(a: Int, b: Int) {
    def +(that: F): F = {
      val B = this.b * that.b
      val A = this.a * that.b + this.b * that.a
      val C = gcd(A.abs, B)
      F(A / C, B / C)
    }

    override def toString: String = {
      s"$a/$b"
    }
  }

  private def gcd(a: Int, b: Int): Int = {
    var x = a
    var y = b
    while (y != 0) {
      val z = y
      y = x % y
      x = z
    }
    x
  }
}
