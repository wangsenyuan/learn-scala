package set000.set000.p003

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    val count = Array.fill(1000)(0)
    var i = 0
    var j = 0
    var best = 0
    while (i < s.length) {
      val x = s(i)
      count(x) += 1

      while (count(x) > 1 && j < i) {
        val y = s(j)
        count(y) -= 1
        j += 1
      }

      best = best max (i - j + 1)

      i += 1
    }

    best
  }
}
