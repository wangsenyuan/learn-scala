package set0000.set400.set470.p472

import scala.collection.mutable.ListBuffer

object Solution {
  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    val root = new Trie

    for {
      word <- words
    } {
      root.add(word)
    }

    def go(word: String, cnt: Int, trie: Trie): Boolean = {
      if (word.isEmpty) {
        cnt > 1 && (trie eq root)
      } else {
        val c = word.head
        val next = trie.find(c)
        if (next == null) {
          false
        } else if (next.leaf && go(word.tail, cnt + 1, root)) {
          true
        } else if (go(word.tail, cnt, next)) {
          true
        } else {
          false
        }
      }
    }

    var res = ListBuffer.empty[String]
    for {
      word <- words
      if (go(word, 0, root))
    } {
      res += word
    }
    res.toList
  }

  class Trie {
    val children = Array.fill[Trie](26)(null)
    var leaf = false

    def add(word: String): Unit = {
      if (word.isEmpty) {
        this.leaf = true
      } else {
        val i = word.head - 'a'
        if (children(i) == null) {
          children(i) = new Trie
        }
        children(i).add(word.tail)
      }
    }

    def find(c: Char): Trie = {
      children(c - 'a')
    }
  }

}
