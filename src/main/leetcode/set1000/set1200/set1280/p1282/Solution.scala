package set1000.set1200.set1280.p1282

import scala.collection.mutable.ListBuffer

object Solution {
  def groupThePeople(groupSizes: Array[Int]): List[List[Int]] = {
    val ii = groupSizes.zipWithIndex.sortBy(_._1)
    val n = ii.length
    val res = ListBuffer.empty[List[Int]]
    var j = 0
    var i = 1
    while (i <= n) {
      if (i == n || ii(j)._1 == i - j) {
        val cur = ListBuffer.empty[Int]
        while (j < i) {
          cur += ii(j)._2
          j += 1
        }
        res += cur.toList
      }
      i += 1
    }
    res.toList
  }
}
