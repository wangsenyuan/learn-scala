package set0000.set100.set160.p168

object Solution {
  def convertToTitle(n: Int): String = {
    val buf = new StringBuilder()

    def go(n: Int): String = {
      if (n == 0) {
        buf.reverse.toString()
      } else {
        val num = n - 1
        val r = num % 26
        buf.append((r + 'A').toChar)
        go(num / 26)
      }
    }

    go(n)
  }
}
