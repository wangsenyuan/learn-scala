package set100.set170.p171

object Solution {
  def titleToNumber(s: String): Int = {
    def go(s: String, res: Int): Int = {
      if (s.isEmpty) {
        res
      } else {
        go(s.tail, res * 26 + 1 + s.head - 'A')
      }
    }

    go(s, 0)
  }
}
