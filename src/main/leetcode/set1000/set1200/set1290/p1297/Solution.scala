package set1000.set1200.set1290.p1297

import scala.collection.mutable

object Solution {
  val MOD = 100000000007L

  def maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int = {
    val cnt = mutable.Map.empty[Long, Int].withDefaultValue(0)
    val letters = mutable.Map.empty[Char, Int].withDefaultValue(0)

    var base = 1L
    var hash = 0L
    var i = 0
    while (i < minSize) {
      val c = s(i)
      letters(c) += 1
      hash = hash * 31 + (c - 'a')
      hash %= MOD
      base *= 31
      base %= MOD
      i += 1
    }

    cnt(hash) = 1
    var res =
      if (letters.size <= maxLetters) {
        1
      } else {
        0
      }

    base /= 31

    while (i < s.length) {
      hash -= base * (s(i - minSize) - 'a')
      if (hash < 0) {
        hash += MOD
      }

      letters(s(i - minSize)) -= 1
      if (letters(s(i - minSize)) == 0) {
        letters.remove(s(i - minSize))
      }

      hash = hash * 31 + s(i) - 'a'
      hash %= MOD

      cnt(hash) += 1

      letters(s(i)) += 1

      if (letters.size <= maxLetters) {
        res = res max cnt(hash)
      }

      i += 1
    }

    res
  }
}
