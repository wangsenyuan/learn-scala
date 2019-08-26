package set0000.set700.set790.p792

import scala.collection.mutable.ArrayBuffer

object Solution {

  def numMatchingSubseq(S: String, words: Array[String]): Int = {
    val ii = Array.ofDim[Int](words.length)

    var res = 0
    var j = 0
    while (j < S.length) {
      var k = 0
      while (k < words.length) {
        val i = ii(k)
        if (i < words(k).length) {

          if (S(j) == words(k)(i)) {
            ii(k) += 1

            if (ii(k) == words(k).length) {
              res += 1
            }
          }

        }

        k += 1
      }

      j += 1
    }
    res
  }

  def numMatchingSubseq1(S: String, words: Array[String]): Int = {
    val root = new Trie
    words.foreach(word => root.add(word))

    var nodes = ArrayBuffer.empty[Trie]
    nodes += root

    var res = 0
    var i = 0
    while (i < S.length) {
      val n = nodes.length
      var j = 0
      while (j < n) {
        val tmp = nodes(j).find(S(i))
        if (tmp != null) {
          if (tmp.count > 0) {
            res += tmp.count
            tmp.count = 0
          }
          nodes += tmp
        }

        j += 1
      }

      i += 1
    }

    res
  }

  class Trie {
    val children = Array.ofDim[Trie](26)
    var count = 0

    def add(word: String): Unit = {
      if (word.isEmpty) {
        count += 1
      } else {
        val x = word.head - 'a'
        if (children(x) == null) {
          children(x) = new Trie
        }
        children(x).add(word.tail)
      }
    }

    def find(x: Char): Trie = {
      children(x - 'a')
    }
  }

}
