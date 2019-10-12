package set0000.set900.set980.p984

object Solution {
  def strWithout3a3b(A: Int, B: Int): String = {
    var m = A
    var n = B
    val buf = new java.lang.StringBuilder()

    while (m > n) {
      buf.append('a')
      m -= 1
      if (m > 0) {
        buf.append('a')
        m -= 1
      }

      if (n > 0) {
        buf.append('b')
        n -= 1
      }
    }

    while (n > m) {
      buf.append('b')
      n -= 1
      if (n > 0) {
        buf.append('b')
        n -= 1
      }

      if (m > 0) {
        buf.append('a')
        m -= 1
      }
    }

    // n == m
    var x = 'a'
    if (buf.length() > 0) {
      x = buf.charAt(buf.length() - 1)
    }

    while (m > 0) {
      buf.append(('a' + 'b' - x).toChar)
      buf.append(x)
      m -= 1
    }

    buf.toString
  }
}
