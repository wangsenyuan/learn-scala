package set000.set020.p029

object Solution {

  def divide(dividend: Int, divisor: Int): Int = {
    if (dividend == 0) {
      0
    } else {
      val dvd = dividend.toLong
      val div = divisor.toLong
      val positive = (dvd > 0) == (div > 0)
      divide(positive, dvd.abs, div.abs)
    }
  }

  private def divide(positive: Boolean, dividend: Long, divisor: Long): Int = {

    def go(dvd: Long, div: Long, res: Long): Long = {
      if (dvd < div) {
        res
      } else {
        var times = 1L
        var tmp = div
        while (dvd >= (tmp << 1)) {
          tmp <<= 1
          times <<= 1
        }
        go(dvd - tmp, div, res + times)
      }
    }

    var res = go(dividend, divisor, 0)
    if (!positive) {
      res *= -1
    }

    if (res > Int.MaxValue) {
      Int.MaxValue
    } else if (res < Int.MinValue) {
      Int.MinValue
    } else {
      res.toInt
    }
  }
}
