package set700.set720.p720

object Solution {
  def longestWord(words: Array[String]): String = {
    val ws = words.sortBy(_.length)
    val root = new Trie
    root.leaf = true

    var best = ""
    ws.foreach(w => {
      val res = root.add(w)
      if(res && (w.length > best.length || (w.length == best.length && w.compareTo(best) < 0))) {
        best = w
      }
    })

    best
  }

  class Trie {
    val children = Array.ofDim[Trie](26)
    var leaf = false

    def add(word: String): Boolean = {
      if(word.isEmpty) {
        this.leaf = true
        true
      } else if(this.leaf){
        val i = word.head - 'a'
        if(children(i) == null) {
          children(i) = new Trie
        }
        children(i).add(word.tail)
      } else {
        false
      }
    }
  }
}
