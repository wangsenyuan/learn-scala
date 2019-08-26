package set0000.set800.set830.p830

import scala.collection.mutable.ListBuffer

object Solution {
  def largeGroupPositions(S: String): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]

    val n = S.length
    var i = 1
    var j = 0
    while (i <= n) {

      if (i == n || S(i) != S(i - 1)) {
        val l = i - j
        if (l >= 3) {
          res += List(j, i - 1)
        }
        j = i
      }

      i += 1
    }

    res.toList
  }
}
