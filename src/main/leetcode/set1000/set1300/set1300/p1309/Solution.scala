package set1000.set1300.set1300.p1309

import scala.collection.mutable

object Solution {

  val ii = mutable.Map.empty[String, String]

  var i = 1
  while (i < 10) {
    ii += i.toString -> ('a' + (i - 1)).toChar.toString
    i += 1
  }

  while (i <= 26) {
    ii += (i.toString + "#") -> ('a' + (i - 1)).toChar.toString
    i += 1
  }

  def freqAlphabets(s: String): String = {
    val buf = new mutable.StringBuilder()
    var i = 0
    while (i < s.length) {
      if (i >= s.length - 2 || s(i) >= '3') {
        buf ++= ii(s.slice(i, i + 1))
        i += 1
      } else if (s(i + 2) != '#') {
        buf ++= ii(s.slice(i, i + 1))
        i += 1
      } else {
        buf ++= ii(s.slice(i, i + 3))
        i += 3
      }
    }
    buf.toString()
  }
}
