package set0000.set900.set960.p966

import scala.collection.mutable

object Solution {
  def spellchecker(wordlist: Array[String], queries: Array[String]): Array[String] = {
    val first = mutable.Set.empty[String]
    val second = mutable.Map.empty[String, String]
    val third = mutable.Map.empty[String, String]

    for {
      word <- wordlist
    } {
      first += word
      val low = word.toLowerCase()
      if (!second.contains(low)) {
        second += low -> word
      }
      val vow = toVowel(low)
      if (!third.contains(vow)) {
        third += vow -> word
      }
    }

    val ans = Array.ofDim[String](queries.length)
    (0 until queries.length).foreach(i => {
      val query = queries(i)
      val low = query.toLowerCase()
      val vow = toVowel(low)
      if (first.contains(query)) {
        ans(i) = query
      } else if (second.contains(low)) {
        ans(i) = second(low)
      } else if (third.contains(vow)) {
        ans(i) = third(vow)
      } else {
        ans(i) = ""
      }
    })
    ans
  }

  private def isVowel(x: Char) = {
    x == 'a' || x == 'o' || x == 'e' || x == 'i' || x == 'u'
  }

  private def toVowel(word: String): String = {
    val buf = new java.lang.StringBuilder()
    var i = 0
    while (i < word.length) {
      val x = word(i)
      if (isVowel(x)) {
        buf.append('a')
      } else {
        buf.append(x)
      }
      i += 1
    }
    buf.toString()
  }
}
