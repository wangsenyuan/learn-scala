package set1000.set1100.set1100.p1104

import scala.collection.mutable.ListBuffer

object Solution {
  def pathInZigZagTree(label: Int): List[Int] = {
    var h = 0
    while (1 << h <= label) {
      h += 1
    }
    // 1 << h >= label
    val res = ListBuffer.empty[Int]
    var pos = findPos(h, label)

    while (h > 0) {
      res += findLabel(h, pos)
      pos >>= 1
      h -= 1
    }

    res.reverse.toList
  }

  private def findPos(h: Int, node: Int): Int = {
    if ((h & 1) == 1) {
      node
    } else {
      val up = 1 << (h - 1)
      val cur = 1 << h
      up - 1 + (cur - node)
    }
  }

  private def findLabel(h: Int, pos: Int): Int = {
    if ((h & 1) == 1) {
      pos
    } else {
      val up = 1 << (h - 1)
      val dist = pos - up
      val cur = 1 << h
      cur - dist - 1
    }
  }

}
