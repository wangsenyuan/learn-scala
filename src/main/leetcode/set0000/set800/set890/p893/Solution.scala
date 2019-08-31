package set0000.set800.set890.p893

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def numSpecialEquivGroups(A: Array[String]): Int = {
    val res = A.map(specialSwap).toSet
    res.size
  }

  private def specialSwap(s: String): String = {
    val cs = s.toCharArray
    val as = ArrayBuffer.empty[Char]
    val bs = ArrayBuffer.empty[Char]
    var i = 0
    while (i < cs.size) {
      if (i % 2 == 0) {
        as += cs(i)
      } else {
        bs += cs(i)
      }
      i += 1
    }

    val a = as.toArray
    val b = bs.toArray
    Sorting.quickSort(a)
    Sorting.quickSort(b)

    val r = ArrayBuffer.empty[Char]
    i = 0
    while (i < cs.size) {
      if (i % 2 == 0) {
        r += a(i / 2)
      } else {
        r += b(i / 2)
      }
      i += 1
    }
    r.mkString("")
  }
}
