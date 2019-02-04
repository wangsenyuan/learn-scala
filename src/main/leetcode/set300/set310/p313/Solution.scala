package set300.set310.p313

import java.util

object Solution {
  def nthSuperUglyNumber(n: Int, primes: Array[Int]): Int = {
    val set = new util.TreeSet[Long]()
    set.add(1)
    var i = 1
    while (i < n) {
      val cur = set.first()
      primes.foreach(num => {
        set.add(cur * num)
      })
      set.remove(cur)
      i += 1
    }

    set.first().toInt
  }
}
