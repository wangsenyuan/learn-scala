package set0000.set600.set680.p680

object Solution {
  def validPalindrome(s: String): Boolean = {
    var i = 0
    var j = s.length - 1
    while (i < j && s(i) == s(j)) {
      i += 1
      j -= 1
    }

    if (i >= j) {
      // no change
      true
    } else {
      // remove s(i) or remove s(j)
      var u = i + 1
      var v = j
      while (u < v && s(u) == s(v)) {
        u += 1
        v -= 1
      }
      if (u >= v) {
        true
      } else {
        //bad luck
        u = i
        v = j - 1
        while (u < v && s(u) == s(v)) {
          u += 1
          v -= 1
        }
        u >= v
      }
    }
  }
}
