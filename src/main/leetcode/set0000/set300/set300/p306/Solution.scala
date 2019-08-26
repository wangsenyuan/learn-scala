package set0000.set300.set300.p306

object Solution {
  def isAdditiveNumber(num: String): Boolean = {
    val n = num.length

    def go(a: BigInt, b: BigInt, i: Int): Boolean = {
      if (i == num.length) {
        true
      } else {
        val c = a + b
        val s = c.toString
        val j = i + s.length
        if (j > num.length) {
          false
        } else if (num.substring(i, j) != s) {
          false
        } else {
          go(b, c, j)
        }
      }
    }

    val ss = for {
      i <- 1 until n - 1
      j <- i + 1 until n
    } yield (i, j)

    ss.exists(p => {
      val (i, j) = p
      val a = num.substring(0, i)
      val b = num.substring(i, j)
      if (i > 1 && a(0) == '0') {
        false
      } else if (j - i > 1 && b(0) == '0') {
        false
      } else {
        go(BigInt(a), BigInt(b), j)
      }
    })
  }
}
