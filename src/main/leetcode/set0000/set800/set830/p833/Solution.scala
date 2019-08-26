package set0000.set800.set830.p833

import scala.util.Sorting

object Solution {
  def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    val rep = Array.ofDim[Replacement](indexes.length)
    var j = 0

    while (j < indexes.length) {
      val ind = indexes(j)
      val source = sources(j)
      val target = targets(j)
      rep(j) = Replacement(ind, source, target)
      j += 1
    }

    Sorting.quickSort(rep)(Ordering.fromLessThan((a, b) => a.index < b.index))

    val buf = new StringBuilder

    j = 0
    var i = 0
    val n = S.length
    while (i < n) {
      if (j < rep.length && i == rep(j).index) {
        if (S.substring(i).startsWith(rep(j).source)) {
          buf.append(rep(j).target)
          i += rep(j).source.length - 1
        } else {
          buf.append(S(i))
        }

        j += 1
      } else {
        buf.append(S(i))
      }

      i += 1
    }

    buf.toString()
  }

  case class Replacement(index: Int, source: String, target: String)

}
