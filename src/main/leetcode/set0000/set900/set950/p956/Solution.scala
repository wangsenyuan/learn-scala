package set0000.set900.set950.p956

object Solution {
  def tallestBillboard(rods: Array[Int]): Int = {
    val M = 5000

    val dp = Array.fill(M + 1)(-1)
    val fp = Array.fill(M + 1)(-1)
    dp(0) = 0

    val n = rods.length

    var i = 0
    while (i < n) {
      val x = rods(i)

      (0 to M).foreach(j => fp(j) = dp(j))

      for {
        y <- 0 to M
        if dp(y) >= 0
      } {
        if (y + x <= M) {
          fp(y + x) = fp(y + x) max (dp(y) + x)
        }

        // put x at right leg
        if (y >= x) {
          fp(y - x) = fp(y - x) max dp(y)
        } else {
          fp(x - y) = fp(x - y) max (dp(y) + x - y)
        }
      }

      (0 to M).foreach(j => dp(j) = fp(j))

      i += 1
    }

    dp(0)
  }
}
