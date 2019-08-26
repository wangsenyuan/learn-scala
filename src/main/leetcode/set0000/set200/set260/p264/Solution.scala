package set0000.set200.set260.p264

import java.util

object Solution {

  def nthUglyNumber(n: Int): Int = {
    val set = new util.TreeSet[Long]()
    set.add(1)
    var i = 1
    while (i < n) {
      val cur = set.first()
      set.add(cur * 2)
      set.add(cur * 3)
      set.add(cur * 5)
      set.remove(cur)
      i += 1
    }

    set.first().toInt
  }
}
