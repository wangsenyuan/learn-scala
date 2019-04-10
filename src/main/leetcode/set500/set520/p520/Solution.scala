package set500.set520.p520

object Solution {
  def detectCapitalUse(word: String): Boolean = {
    if (word.length <= 1) {
      true
    } else {
      val first = word(0).isUpper
      if (first) {
        val second = word(1).isUpper
        var i = 2
        while (i < word.length && word(i).isUpper == second) {
          i += 1
        }
        i == word.length
      } else {
        var i = 1
        while (i < word.length && word(i).isLower) {
          i += 1
        }
        i == word.length
      }
    }
  }
}
