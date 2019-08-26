package set1000.set1000.set1030.p1032

class StreamChecker(_words: Array[String]) {
  val root = new Trie

  _words.foreach(word => root.add(word))

  var cur = Array.empty[Trie]

  def query(letter: Char): Boolean = {
    cur = cur.map(_.query(letter)).filter(_ != null)
    val next = root.query(letter)
    if(next != null) {
      cur = cur :+ next
    }
    cur.exists(_.leaf)
  }

  class Trie {
    var leaf = false
    val children = Array.ofDim[Trie](26)

    def add(word: String): Unit = {
      if(word.isEmpty) {
        this.leaf = true
      } else {
        val i = word.head - 'a'
        if(children(i) == null) {
          children(i) = new Trie
        }
        children(i).add(word.tail)
      }
    }

    def query(letter: Char): Trie = {
      children(letter - 'a')
    }
  }
}
