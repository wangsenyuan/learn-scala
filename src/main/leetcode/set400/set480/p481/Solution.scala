package set400.set480.p481

object Solution {
  def magicalString(n: Int): Int = {
    if (n == 0) {
      0
    } else if (n <= 3) {
      1
    } else {
      val s = StringBuilder.newBuilder
      s.append("122")
      var i = 2
      var j = 3

      while (j < n) {
        if (s(i) == '1') {
          s.append(diff(s(j - 1)))
          i += 1
          j += 1
        } else {
          //s(i) == '2'
          val x = diff(s(j-1))
          s.append(x)
          j += 1
          s.append(x)
          j += 1
          i += 1
        }
      }

      s.take(n).count(_ == '1')
    }
  }

  private def diff(c: Char): Char = {
    if (c == '1') {
      '2'
    } else {
      '1'
    }
  }
}
