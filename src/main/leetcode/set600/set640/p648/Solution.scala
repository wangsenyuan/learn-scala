package set600.set640.p648

import scala.collection.mutable.ArrayBuffer

object Solution {
  def replaceWords(dict: List[String], sentence: String): String = {
    val tree = new Trie
    dict.foreach(word => tree.add(word))

    val words = sentence.split("\\s+")

    def replace(word: String): String = {
      val res = findPrefix(tree, word)
      if (res.isEmpty) {
        word
      } else {
        res
      }
    }

    val buf = ArrayBuffer.empty[String]

    words.foreach(word => buf.append(replace(word)))

    buf.mkString(" ")
  }

  class Trie {
    val children = Array.ofDim[Trie](26)
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
  }

  private def findPrefix(tree: Trie, word: String): String = {
    var node = tree
    var i = 0
    var res = StringBuilder.newBuilder
    while(node != null && i < word.length) {
      res += word(i)
      node = node.children(word(i) - 'a')
      if(node != null && node.leaf) {
        return res.toString()
      }
      i += 1
    }

    return ""
  }

}
