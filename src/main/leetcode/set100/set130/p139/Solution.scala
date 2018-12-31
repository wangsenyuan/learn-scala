package set100.set130.p139

import scala.collection.mutable

object Solution {

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val ws = wordDict.toSet
    val n = s.length
    val dp = Array.fill(n + 1)(false)
    dp(0) = true

    var i = 1
    while (i <= n) {
      var j = i
      while (j > 0 && !dp(i)) {
        dp(i) = ws.contains(s.substring(j - 1, i)) && dp(j - 1)
        j -= 1
      }

      i += 1
    }


    dp(n)
  }

  def wordBreak1(s: String, wordDict: List[String]): Boolean = {
    val ws = wordDict.toSet

    val mem = mutable.Map.empty[String, Int].withDefaultValue(0)

    def go(s: String): Int = {
      if (s.isEmpty || ws.contains(s)) {
        1
      } else if (mem(s) == 0) {
        var i = 1
        var can = false
        while (i < s.length && !can) {
          if (ws.contains(s.substring(0, i))) {
            val r = go(s.substring(i))
            if (r == 1) {
              can = true
            }
          }
          i += 1
        }
        if (can) {
          mem(s) = 1
        } else {
          mem(s) = -1
        }
        mem(s)
      } else {
        mem(s)
      }
    }

    go(s) == 1
  }
}
