package set0000.set900.set950.p954

import scala.collection.mutable

object Solution {
  def canReorderDoubled(A: Array[Int]): Boolean = {
    val arr = A.sortWith(abs)

    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

    arr.foreach(num => cnt(num) += 1)

    def decrement(num: Int): Unit = {
      if (cnt(num) == 1) {
        cnt -= num
      } else {
        cnt(num) -= 1
      }
    }

    val n = A.length

    var i = 0

    while (i < n) {
      val num = arr(i)

      if (cnt(num) > 0) {
        val dnum = 2 * num
        if (cnt(dnum) == 0) {
          return false
        }
        decrement(num)
        decrement(dnum)
      }

      i += 1
    }

    cnt.size == 0
  }

  private def abs(a: Int, b: Int) = a.abs < b.abs
}
