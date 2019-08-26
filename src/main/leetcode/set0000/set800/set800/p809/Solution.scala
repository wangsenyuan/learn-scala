package set0000.set800.set800.p809

object Solution {
  def expressiveWords(S: String, words: Array[String]): Int = {
    def check(word: String): Boolean = {
      var i = 0
      var j = 0
      var can = true
      while (i < S.length && j < word.length && can) {
        if (S(i) != word(j)) {
          can = false
        } else {
          var u = j
          while (u < word.length && word(u) == word(j)) {
            u += 1
          }

          var v = i
          while (v < S.length && S(v) == S(i)) {
            v += 1
          }
          if (v - i == u - j) {
            // no stretch
            i = v
            j = u
          } else if (v - i > u - j && v - i >= 3) {
            // stretch a little
            i = v
            j = u
          } else {
            can = false
          }
        }
      }

      can && i == S.length && j == word.length
    }

    words.count(check)
  }
}
