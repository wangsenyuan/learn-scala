package set0000.set900.set900.p906

object Solution {
  def superpalindromesInRange(L: String, R: String): Int = {
    // 1 to 100000 and count it?
    // len(z) <= 18 => len(y) <= 9 => y <= 999999999 => y < 1000000000
    // 99999 99999 => 1e10 => 1e20
    val N1 = 100000
    var res = 0
    var loop = true
    var x = 1
    while (x < N1 && loop) {
      val y = mirror(x)

      // y is palindrome
      val z = y * y

      if (z < 0) {
        // overflow
        loop = false
      } else {
        val w = z.toString

        if (compare(w, R) > 0) {
          loop = false
        } else if (compare(w, L) >= 0 && w.reverse == w) {
          res += 1
        }
      }

      x += 1
    }

    x = 10
    loop = true
    while (x < N1 && loop) {
      val y = mirrorAtCenter(x)

      val z = y * y

      if (z < 0) {
        // overflow
        loop = false
      } else {
        val w = z.toString

        if (compare(w, R) > 0) {
          loop = false
        } else if (compare(w, L) >= 0 && w.reverse == w) {
          res += 1
        }
      }

      x += 1
    }

    loop = true
    x = 1
    while (x < 10 && loop) {
      val y = x * x
      val w = y.toString
      if (compare(w, R) > 0) {
        loop = false
      } else if (compare(w, L) >= 0 && w.reverse == w) {
        res += 1
      }
      x += 1
    }

    res
  }

  private def compare(a: String, b: String): Int = {
    if (a.length < b.length || (a.length == b.length && a < b)) {
      -1
    } else if (a == b) {
      0
    } else {
      1
    }
  }

  private def mirror(num: Int): Long = {
    val s = num.toString
    val r = s.reverse
    (s + r).toLong
  }

  private def mirrorAtCenter(num: Int): Long = {
    val x = num / 10
    val s = x.toString
    val r = s.reverse
    (s + (num % 10).toString + r).toLong
  }
}
