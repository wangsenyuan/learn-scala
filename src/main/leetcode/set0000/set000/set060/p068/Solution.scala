package set0000.set000.set060.p068

object Solution {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    val n = words.length

    def pickWords(i: Int): Int = {
      var j = i
      var len = 0
      while (j < n && len + words(j).length <= maxWidth) {
        len += words(j).length
        len += 1
        j += 1
      }
      j
    }

    def justify(ws: Array[String]): String = {
      if (ws.length == 1) {
        ws(0) + (" " * (maxWidth - ws(0).length))
      } else {
        val len = ws.map(_.length).sum
        val left = maxWidth - len
        val a = left / (ws.length - 1)
        val b = left % (ws.length - 1)
        var i = 0
        var res = ""
        while (i < b) {
          res += ws(i)
          res += " " * (a + 1)
          i += 1
        }

        while (i < ws.length - 1) {
          res += ws(i)
          res += " " * a
          i += 1
        }
        res += ws(i)

        res
      }
    }

    def justifyLastRow(ws: Array[String]): String = {
      var res = ""
      var i = 0
      while (i < ws.length - 1) {
        res += ws(i)
        res += " "
        i += 1
      }
      res += ws(i)
      res += " " * (maxWidth - res.length)
      res
    }

    def go(i: Int, res: List[String]): List[String] = {
      val j = pickWords(i)
      if (j == n) {
        //last line
        val row = justifyLastRow(words.slice(i, n))
        row :: res
      } else {
        val row = justify(words.slice(i, j))
        go(j, row :: res)
      }
    }

    val res = go(0, Nil)

    res.reverse
  }
}
