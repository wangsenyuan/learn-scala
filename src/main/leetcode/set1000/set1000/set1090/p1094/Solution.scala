package set1000.set1000.set1090.p1094

import scala.util.Sorting

object Solution {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    val n = trips.length
    val items = Array.ofDim[Item](2 * n)
    var i = 0
    while (i < n) {
      val num = trips(i)(0)
      val start = trips(i)(1)
      val end = trips(i)(2)

      items(2 * i) = Item(start, num)
      items(2 * i + 1) = Item(end, -num)

      i += 1
    }

    Sorting.stableSort(items)
    var num = 0
    i = 0
    while (i < items.length) {
      num += items(i).num
      if (num > capacity) {
        return false
      }
      i += 1
    }
    true
  }

  case class Item(pos: Int, num: Int) extends Comparable[Item] {
    override def compareTo(that: Item): Int = {
      if (this.pos < that.pos) {
        -1
      } else if (this.pos == that.pos && this.num < that.num) {
        -1
      } else {
        1
      }
    }
  }

}
