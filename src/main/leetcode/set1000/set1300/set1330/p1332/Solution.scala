package set1000.set1300.set1330.p1332

object Solution {
  def removePalindromeSub(s: String): Int = {
    if (s.isEmpty) {
      0
    } else {
      var i = 0
      var j = s.length - 1
      while (i < j && s(i) == s(j)) {
        i += 1
        j -= 1
      }
      if (i >= j) {
        1
      } else {
        2
      }
    }
  }
}
