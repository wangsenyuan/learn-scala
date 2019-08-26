package set0000.set800.set800.p806

object Solution {
  def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
    if(S.isEmpty) {
      Array(0, 0)
    } else {
      var lines = 1
      var width = 0
      var i = 0
      while (i < S.length) {
        val x = S(i) - 'a'
        val w = widths(x)

        if (width + w <= 100) {
          width += w
        } else {
          lines += 1
          width = w
        }
        i += 1
      }

      Array(lines, width)
    }
  }
}
