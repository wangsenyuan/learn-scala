package set0000.set800.set890.p898

import scala.collection.mutable

object Solution {
  def subarrayBitwiseORs(A: Array[Int]): Int = {
    val ans = mutable.Set.empty[Int]
    var cur = mutable.Set.empty[Int]
    cur += 0

    A.foreach(num => {
      val cur2 = mutable.Set.empty[Int]
      for {
        x <- cur
      } {
        cur2 += x | num
      }
      cur2 += num
      ans ++= cur2
      cur = cur2
    })

    ans.size
  }

  def subarrayBitwiseORs1(A: Array[Int]): Int = {
    var set = mutable.Set.empty[Int]

    var i = 0
    while (i < A.length) {
      val num = A(i)

      var tmp = num
      var j = i - 1
      while (j >= 0 && A(j) != num) {
        tmp |= A(j)
        set += tmp
        j -= 1
      }
      set += num

      i += 1
    }

    set.size
  }
}
