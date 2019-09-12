package set0000.set900.set920.p921

object Solution {
  def minAddToMakeValid(S: String): Int = {
    val n = S.length
    var left = 0
    var right = 0
    var ans = 0
    var i = 0
    while (i < n) {
      if (S(i) == '(') {
        left += 1
      } else {
        right += 1
      }

      if (right > left) {
        ans += right - left
        right = left
      }

      i += 1
    }

    ans += left - right

    ans
  }
}
