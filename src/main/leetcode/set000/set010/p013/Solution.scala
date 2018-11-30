package set000.set010.p013

object Solution {
  val map = Map("M" -> 1000, "CM" -> 900, "D" -> 500, "CD" -> 400
    , "C" -> 100, "XC" -> 90, "L" -> 50, "XL" -> 40, "X" -> 10, "IX" -> 9
    , "V" -> 5, "IV" -> 4, "I" -> 1)

  def romanToInt(s: String): Int = {
    def go(s: String, cur: Int): Int = {
      if (s.isEmpty) {
        cur
      } else if (s.length >= 2 && map.contains(s.substring(0, 2))) {
        go(s.substring(2), cur + map(s.substring(0, 2)))
      } else {
        go(s.substring(1), cur + map(s.substring(0, 1)))
      }
    }

    go(s, 0)
  }
}
