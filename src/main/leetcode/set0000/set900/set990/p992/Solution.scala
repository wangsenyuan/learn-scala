package set0000.set900.set990.p992

import scala.collection.mutable

object Solution {
  def subarraysWithKDistinct(A: Array[Int], K: Int): Int = {
    val wnd1 = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val wnd2 = mutable.Map.empty[Int, Int].withDefaultValue(0)

    def add(wnd: mutable.Map[Int, Int], num: Int): Unit = {
      wnd(num) += 1
    }

    def remove(wnd: mutable.Map[Int, Int], num: Int): Unit = {
      if (wnd(num) > 1) {
        wnd(num) -= 1
      } else {
        wnd.remove(num)
      }
    }

    var res = 0
    var j = 0
    var k = 0

    for {
      num <- A
    } {
      add(wnd1, num)
      add(wnd2, num)
      while (wnd1.size >= K) {
        remove(wnd1, A(k))
        k += 1
      }
      while (wnd2.size > K) {
        remove(wnd2, A(j))
        j += 1
      }
      res += k - j
    }


    res
  }
}
