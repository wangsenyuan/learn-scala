package set0000.set700.set740.p745

class WordFilter(_words: Array[String]) {
    val root = new Trie()

    _words.zipWithIndex.foreach(x => {
        addWord(x._1, x._2)
    })

    private def addWord(word: String, weight: Int): Unit = {
        val n = word.length
        val w = word + '{'
        var i = 0
        while(i < w.length) {
            var node = root
            node.weight = weight
            var j = i
            while(j < 2 * w.length - 1) {
                node = node.add(w(j % w.length))
                node.weight = weight
                j += 1
            }

            i += 1
        }
    }

    def f(prefix: String, suffix: String): Int = {
        val word = suffix + '{' + prefix
        var node = root
        var i = 0
        while(node != null && i < word.length) {
            node = node.get(word(i))
            i += 1
        }
        if(node == null) {
            -1
        } else {
            node.weight
        }
    }

    class Trie() {
        val children = Array.ofDim[Trie](27)
        var weight = -1

        def add(c: Char): Trie = {
            val i = c - 'a'
            if(children(i) == null) {
                children(i) = new Trie()
            }
            children(i)
        }

        def get(c: Char): Trie = {
            val i = c - 'a'
            children(i)
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = new WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
