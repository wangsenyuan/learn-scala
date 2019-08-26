package set0000.set600.set670.p676

class MagicDictionary() {

  /** Initialize your data structure here. */
  val root = new Node

  /** Build a dictionary through a list of words */
  def buildDict(dict: Array[String]) {
    dict.foreach(word => root.add(word))
  }

  /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
  def search(word: String): Boolean = {

    def loop(i: Int, node: Node, change: Int): Boolean = {
      if (i == word.length) {
        node.leaf && change == 1
      } else if (node == null) {
        false
      } else if (change > 1) {
        false
      } else {
        val next = node.children(word(i) - 'a')
        var can = next != null && loop(i + 1, next, change)

        var j = 0
        while (!can && j < 26) {
          if (node.children(j) != null && j != word(i) - 'a') {
            can = loop(i + 1, node.children(j), change + 1)
          }
          j += 1
        }
        can
      }
    }

    loop(0, root, 0)
  }

  class Node {
    var leaf = false

    val children = Array.ofDim[Node](26)

    def add(word: String): Unit = {
      if (word.isEmpty) {
        this.leaf = true
      } else {
        val i = word.head - 'a'
        if (children(i) == null) {
          children(i) = new Node
        }
        children(i).add(word.tail)
      }
    }

  }

}
