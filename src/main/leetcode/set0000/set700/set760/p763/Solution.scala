package set0000.set700.set760.p763

import scala.collection.mutable.ListBuffer

object Solution {
  def partitionLabels(str: String): List[Int] = {
    val pos = Array.fill(26)(-1)
    val n = str.length

    var i = 0
    while(i < n) {
      val x = str(i) - 'a'
      pos(x) = i
      i += 1
    }
    var res = ListBuffer.empty[Int]
    var end = 0
    var len = 0
    i = 0
    while(i < n) {
      if(i > end) {
        res += len
        len = 0
      }

      end = end max pos(str(i) - 'a')
      len += 1
      i += 1
    }

    res += len

    res.toList
  }
}
