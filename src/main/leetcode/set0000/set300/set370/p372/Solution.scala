package set0000.set300.set370.p372

object Solution {

  val MOD = 1337

  def superPow(a: Int, b: Array[Int]): Int = {
    val x = a % MOD
    var y = 1
    var i = 0
    while (i < b.length) {
      y = (pow(y, 10) * pow(x, b(i))) % MOD
      i += 1
    }
    y
  }

  private def pow(a: Int, b: Int): Int = {
    if (b == 0) {
      1
    } else {
      val c = pow(a, b / 2)
      val d = (c * c) % MOD
      if (b % 2 == 1) {
        (a * d) % MOD
      } else {
        d
      }
    }
  }
}
