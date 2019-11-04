package set1000.set1000.set1040.p1048

import scala.collection.mutable

object Solution {
  def longestStrChain(words: Array[String]): Int = {
    val byLen = words.groupBy(_.length)

    val lens = byLen.keys.toArray.sorted

    val mem = mutable.Map.empty[String, Int].withDefaultValue(1)

    var i = lens.length - 1

    //    byLen(lens(i)).foreach(s => mem(s) = 1)

    var best = 1

    i -= 1

    while (i >= 0) {
      val xs = byLen(lens(i))
      if (lens(i + 1) == lens(i) + 1) {
        val ys = byLen(lens(i + 1))
        for {
          x <- xs
          y <- ys
        } {
          if (mem(x) < mem(y) + 1 && precedes(x, y)) {
            mem(x) = mem(y) + 1
          }
        }
      }

      for {
        x <- xs
      } {
        best = best max mem(x)
      }

      i -= 1
    }

    best
  }

  private def precedes(a: String, b: String): Boolean = {
    var i = 0
    var j = 0
    while (i < a.length && j < b.length && a(i) == b(j)) {
      i += 1
      j += 1
    }
    if (i == a.length) {
      true
    } else {
      //s(i) != s(j)
      j += 1
      while (i < a.length && j < b.length && a(i) == b(j)) {
        i += 1
        j += 1
      }
      i == a.length && j == b.length
    }
  }
}
