package set100.set120.p127

import scala.collection.mutable.ListBuffer

object Solution {
  val INF = Int.MaxValue >> 1

  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    if (!wordList.contains(endWord)) {
      0
    } else {

      val words = if (wordList.contains(beginWord)) {
        wordList.toArray
      } else {
        (beginWord :: wordList).toArray
      }
      val ws = words.zipWithIndex.toMap

      val n = words.length
      val dist = Array.fill(n)(INF)

      dist(ws(endWord)) = 0

      val que = Array.fill(n)(0)

      que(0) = ws(endWord)
      var front = 0
      var tail = 1
      while (front < tail) {
        val i = que(front)
        front += 1
        val cur = words(i)
        val ss = transform(cur, ws)
        for {
          s <- ss
        } {
          val j = ws(s)
          if (dist(j) > dist(i) + 1) {
            dist(j) = dist(i) + 1
            que(tail) = ws(s)
            tail += 1
          }
        }
      }

      if (dist(ws(beginWord)) == INF) {
        0
      } else {
        dist(ws(beginWord)) + 1
      }
    }
  }

  private def transform(word: String, ws: Map[String, Int]): Seq[String] = {
    val cs = word.toCharArray
    val buf = ListBuffer.empty[String]
    var i = 0
    while (i < cs.length) {
      var j = 0
      while (j < 26) {
        if (j != cs(i) - 'a') {
          val old = cs(i)
          cs(i) = ('a' + j).toChar

          val s = new String(cs)
          if (ws.contains(s)) {
            buf += s
          }

          cs(i) = old
        }

        j += 1
      }

      i += 1
    }

    buf.toVector
  }
}
