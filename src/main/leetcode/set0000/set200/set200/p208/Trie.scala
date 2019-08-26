package set0000.set200.set200.p208

class Trie() {

  /** Initialize your data structure here. */

  class Node {
    val children = Array.fill[Node](26)(null)
    var leaf = false

    def insert(word: String): Unit = {
      if (word.isEmpty) {
        leaf = true
      } else {
        val idx = word.head - 'a'
        if (children(idx) == null) {
          children(idx) = new Node
        }
        val child = children(idx)
        child.insert(word.tail)
      }
    }

    def search(word: String): Boolean = {
      if (word.isEmpty) {
        leaf
      } else {
        val idx = word.head - 'a'
        children(idx) != null && children(idx).search(word.tail)
      }
    }

    def startWith(prefix: String): Boolean = {
      if (prefix.isEmpty) {
        true
      } else {
        val idx = prefix.head - 'a'
        children(idx) != null && children(idx).startWith(prefix.tail)
      }
    }
  }

  val root = new Node

  /** Inserts a word into the trie. */
  def insert(word: String) {
    root.insert(word)
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    root.search(word)
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    root.startWith(prefix)
  }

}
