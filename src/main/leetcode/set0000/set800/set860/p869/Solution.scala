package set0000.set800.set860.p869

import scala.collection.mutable.ArrayBuffer

object Solution {
  def reorderedPowerOf2(N: Int): Boolean = {
    val ps = ArrayBuffer.empty[Long]
    var x = 1L
    while (x < 1e10) {
      ps += x
      x <<= 1
    }
    val ns = ps.map(_.toString.toCharArray.groupBy(identity).view.mapValues(_.size).toMap)
    val num = N.toString.toCharArray.groupBy(identity).view.mapValues(_.size).toMap
    var i = 0
    while (i < ns.length && !mapEquals(num, ns(i))) {
      i += 1
    }
    i < ns.length
  }

  private def mapEquals(a: Map[Char, Int], b: Map[Char, Int]): Boolean = {
    if (a.size != b.size) {
      false
    } else {
      for {
        x <- a
      } {
        if (!b.contains(x._1) || b(x._1) != x._2) {
          return false
        }
      }

      true
    }
  }
}
