package set400.set460.p467

object Solution {
  def findSubstringInWraproundString(p: String): Int = {
    val dp = Array.ofDim[Int](26)

    val q = p.map(c => (c - 'a'))

    val n = p.length
    var i = 0
    while (i < n) {
      var j = 0
      while (i + j < n && q(i + j) == (q(i) + j) % 26) {
        if(dp(q(i+j)) < j + 1) {
          dp(q(i+j)) = j + 1
        }
        j += 1
      }

      i += j
    }

    dp.sum
  }
}
