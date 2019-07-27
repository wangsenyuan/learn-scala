package set800.set820.p820

import scala.util.Sorting

object Solution {
  def minimumLengthEncoding(words: Array[String]): Int = {
    val ws = words.map(_.reverse)

    Sorting.quickSort(ws)

    var res = 0

    var j = 0
    var i = 1
    while(i  <= ws.length) {
      if(i == ws.length || !ws(i).startsWith(ws(i-1))) {
        res += ws(i-1).length + 1
        j = i
      }
      i += 1
    }
    res
  }
}
