package set0000.set200.set210.p211

class WordDictionary() {

  /** Initialize your data structure here. */
  class Node {
    val children = Array.fill[Node](26)(null)
    var leaf = false

    def add(word: String): Unit = {
      if (word.isEmpty) {
        leaf = true
      } else {
        val idx = word.head - 'a'
        if (children(idx) == null) {
          children(idx) = new Node()
        }
        children(idx).add(word.tail)
      }
    }

    def search(word: String): Boolean = {
      if (word.isEmpty) {
        leaf
      } else {
        if (word.head == '.') {
          (0 until 26).exists(i => children(i) != null && children(i).search(word.tail))
        } else {
          val idx = word.head - 'a'
          children(idx) != null && children(idx).search(word.tail)
        }
      }
    }
  }

  val root = new Node()

  /** Adds a word into the data structure. */
  def addWord(word: String) {
    root.add(word)
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  def search(word: String): Boolean = {
    root.search(word)
  }

}
