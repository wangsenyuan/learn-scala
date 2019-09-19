package set0000.set000.set070.p076

import scala.collection.mutable

object Solution {
  def minWindow(s: String, t: String): String = {
    val cnt = t.groupBy(identity).mapValues(_.length)
    val count = mutable.Map.empty[Char, Int]

    def hasMore(c: Char): Boolean = {
      if (cnt(c) == 0) {
        true
      } else if (count.getOrElse(c, 0) > cnt(c)) {
        true
      } else {
        false
      }
    }

    def check(): Boolean = {
      if (count.size < cnt.size) {
        false
      } else {
        cnt.forall(item => {
          val (k, v) = item
          count.getOrElse(k, 0) >= v
        })
      }
    }

    val n = s.length

    def go(i: Int, j: Int, best: String): String = {
      if (i == n) {
        best
      } else {
        if (cnt(s(i)) > 0) {
          //only characters in T matters
          val x = count.getOrElse(s(i), 0)
          count(s(i)) = x + 1
          if (check()) {
            //a candidate
            var k = j
            while (k < i && hasMore(s(k))) {
              val y = count.getOrElse(s(k), 0)
              if (y > 1) {
                count(s(k)) = y - 1
              }
              k += 1
            }
            go(i + 1, k, min(best, s.substring(k, i + 1)))
          } else {
            go(i + 1, j, best)
          }
        } else {
          go(i + 1, j, best)
        }
      }
    }

    val res = go(0, 0, s)

    if (res.length < s.length) {
      res
    } else if (check()) {
      s
    } else {
      ""
    }
  }

  private def min(a: String, b: String): String = {
    if (a.length < b.length) {
      a
    } else {
      b
    }
  }
}
