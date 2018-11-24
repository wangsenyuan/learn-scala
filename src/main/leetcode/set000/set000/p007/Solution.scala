package set000.set000.p007

object Solution {
  def reverse(x: Int): Int = {
    val s = sign(x)
    val res = s * process(s * x)
    if (res > Int.MaxValue || res < Int.MinValue) {
      0
    } else {
      res.toInt
    }
  }

  private def process(num: Long): Long = {
    var power = 1L
    while (num >= power * 10) {
      power *= 10
    }

    def go(num: Long, power: Long): Long = {
      if (num == 0) {
        0
      } else {
        go(num % power, power / 10) * 10 + num / power
      }
    }

    go(num, power)
  }

  private def sign(x: Int): Int = if (x < 0) -1 else 1
}
