package set1000.set1100.set1170.p1178

import scala.collection.mutable

object Solution {
  def findNumOfValidWords(words: Array[String], puzzles: Array[String]): List[Int] = {
    val cnt = mutable.Map.empty[Key, Int].withDefaultValue(0)
    val vis = Array.ofDim[Boolean](26)
    var i = 0
    while (i < words.length) {
      var j = 0
      while (j < 26) {
        vis(j) = false
        j += 1
      }
      val w = words(i)
      val x = toMask(w)
      j = 0
      while (j < w.length) {
        val h = w(j) - 'a'
        if (!vis(h)) {
          vis(h) = true
          cnt(Key(h, x)) += 1
        }
        j += 1
      }
      i += 1
    }

    val n = puzzles.length
    val ans = Array.ofDim[Int](n)

    i = 0
    while (i < n) {
      val pz = puzzles(i)
      val h = pz.head - 'a'

      val t = pz.tail
      val m = t.length
      val M = 1 << m
      var state = 0
      while (state < M) {
        var r = 1 << h
        var j = 0
        while (j < m) {
          if ((state & (1 << j)) > 0) {
            r |= (1 << (t(j) - 'a'))
          }
          j += 1
        }
        ans(i) += cnt(Key(h, r))
        state += 1
      }

      i += 1
    }

    ans.toList
  }

  case class Key(first: Int, left: Int)

  private def toMask(s: String): Int = {
    var r = 0
    var i = 0
    while (i < s.length) {
      r |= (1 << (s(i) - 'a'))
      i += 1
    }
    r
  }
}
