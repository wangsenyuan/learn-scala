package set100.set140.p140

import scala.collection.mutable

object Solution {
  def wordBreak(s: String, wordDict: List[String]): List[String] = {
    val ws = wordDict.toSet
    val cache = mutable.Map.empty[String, List[String]]

    def go(s: String): List[String] = {
      if (s.isEmpty) {
        List("")
      } else if (!cache.contains(s)) {
        var res = List.empty[String]
        var i = 1
        while (i <= s.length) {
          if (ws.contains(s.substring(0, i))) {
            val sub = go(s.substring(i))
            res ++= sub.map(s.substring(0, i) + " " + _)
          }
          i += 1
        }
        cache(s) = res
        res
      } else {
        cache(s)
      }
    }

    val res = go(s)
    res.map(_.trim)
  }
}
