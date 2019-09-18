package set0000.set900.set940.p949

object Solution {
  def largestTimeFromDigits(A: Array[Int]): String = {
    val cnt = Array.ofDim[Int](10)
    A.foreach(a => cnt(a) += 1)
    var x = 60 * 24 - 1
    while (x >= 0 && !check(x, cnt)) {
      x -= 1
    }
    if (x < 0) {
      ""
    } else {
      format(x)
    }
  }

  private def format(x: Int): String = {
    val digits = parse(x)
    f"${digits(0)}${digits(1)}:${digits(2)}${digits(3)}"
  }

  private def parse(x: Int): Array[Int] = {
    val hour = x / 60
    val min = x % 60
    val a = hour / 10
    val b = hour % 10
    val c = min / 10
    val d = min % 10
    Array(a, b, c, d)
  }

  private def check(x: Int, cnt: Array[Int]): Boolean = {
    val digits = parse(x)

    val cnt2 = Array.ofDim[Int](10)

    digits.foreach(d => cnt2(d) += 1)

    (0 until 10).forall(i => cnt(i) == cnt2(i))
  }
}
