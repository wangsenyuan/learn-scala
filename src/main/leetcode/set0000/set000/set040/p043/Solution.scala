package set0000.set000.set040.p043

object Solution {

  def multiply(num1: String, num2: String): String = {
    val n = num1.length max num2.length
    val res = mul(normalize(num1, n), normalize(num2, n))
    if (res.isEmpty) {
      "0"
    } else {
      res
    }
  }

  def normalize(s: String, n: Int): String = {
    "0" * (n - s.length) + s
  }

  def mul(num1: String, num2: String): String = {
    if (num1.isEmpty || num2.isEmpty) {
      "0"
    } else {
      val n = num1.length
      val m = num2.length
      if (n < 2 && m < 2) {
        val x = num1.toLong
        val y = num2.toLong
        (x * y).toString
      } else {
        val k = m min n
        val k2 = k / 2
        val k3 = k - k2
        val (high1, low1) = num1.splitAt(k2)
        val (high2, low2) = num2.splitAt(k2)
        val z0 = multiply(low1, low2)
        val z1 = multiply(add(low1, high1), add(low2, high2))
        val z2 = multiply(high1, high2)
        val first = shift(z2, k3 * 2)
        val second = shift(sub(sub(z1, z2), z0), k3)
        add(add(first, second), z0).dropWhile(_ == '0')
      }
    }
  }

  def shift(str: String, cnt: Int): String = {
    str + ("0" * cnt)
  }

  def add(num1: String, num2: String): String = {
    if (num1.isEmpty) {
      num2
    } else if (num2.isEmpty) {
      num1
    } else {
      def go(num1: String, num2: String): String = {
        val n = num1.length
        val m = num2.length
        if (n < m) {
          add(num2, num1)
        } else if (n > m) {
          add(num1, ("0" * (n - m)) + num2)
        } else {
          //n == m
          val res = new StringBuilder()
          var carry = 0
          var i = n - 1
          while (i >= 0) {
            val x = num1(i) - '0'
            val y = num2(i) - '0'
            val z = carry + x + y
            res.append(z % 10)
            carry = z / 10
            i -= 1
          }
          if (carry > 0) {
            res.append(carry)
          }
          res.reverse.mkString
        }
      }

      val res =
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
          "-" + go(num1.tail, num2.tail)
        } else if (num2.charAt(0) == '-') {
          sub(num1, num2.tail)
        } else if (num1.charAt(0) == '-') {
          sub(num2, num1.tail)
        } else {
          go(num1, num2)
        }
      res.dropWhile(_ == '0')
    }
  }

  def sub(num1: String, num2: String): String = {
    if (num1.isEmpty) {
      sub("0", num2)
    } else if (num2.isEmpty) {
      num1
    } else {
      def go(num1: String, num2: String): String = {
        //num1 >= num2
        val x = num1.toCharArray
        val y = num2.toCharArray
        val res = new StringBuilder()
        var i = num1.length - 1
        var j = num2.length - 1
        while (i >= 0 && j >= 0) {
          val a = x(i) - '0'
          val b = y(j) - '0'
          if (a >= b) {
            res.append(a - b)
          } else {
            //need to borrow from higher position
            var k = i - 1
            while (k >= 0 && x(k) == '0') {
              k -= 1
            }
            // x(k) > 0
            x(k) = (x(k) - 1).toChar
            k += 1
            while (k < i) {
              x(k) = '9'
              k += 1
            }
            res.append(10 + a - b)
          }
          i -= 1
          j -= 1
        }

        while (i >= 0) {
          res.append(x(i))
          i -= 1
        }
        res.reverse.toString().dropWhile(_ == '0')
      }

      val res =
        if (num2.charAt(0) == '-') {
          add(num1, num2.tail)
        } else if (num1.charAt(0) == '-') {
          sub(num2, num1.tail)
        } else if (less(num1, num2)) {
          "-" + go(num2, num1)
        } else {
          go(num1, num2)
        }
      res.dropWhile(_ == '0')
    }
  }

  def less(a: String, b: String): Boolean = {
    if (a.length < b.length) {
      true
    } else if (a.length > b.length) {
      false
    } else {
      a.compareTo(b) < 0
    }
  }
}
