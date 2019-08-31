package set0000.set800.set890.p890

import scala.collection.mutable

object Solution {
  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {

    val map = mutable.Map.empty[Char, Char]
    val rmap = mutable.Map.empty[Char, Char]

    def checkPattern(word: String): Boolean = {
      map.clear()
      rmap.clear()

      if (word.length != pattern.length) {
        false
      } else {
        var i = 0
        while (i < word.length) {
          val x = word(i)
          val y = pattern(i)

          if (map.contains(x)) {
            if (map(x) != y) {
              return false
            }
          } else if (rmap.contains(y)) {
            return false
          } else {
            map += x -> y
            rmap += y -> x
          }

          i += 1
        }

        i == word.length
      }
    }

    words.filter(checkPattern).toList
  }

}
