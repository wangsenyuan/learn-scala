package set900.set970.p975

import java.util

object Solution {
  def oddEvenJumps(A: Array[Int]): Int = {
    val n = A.length
    val tree = new util.TreeMap[Int, Int]()
    val gt = Array.fill(n)(-1)
    val lt = Array.fill(n)(-1)

    for {
      i <- n - 1 to 0 by -1
    } {
      val ceil = tree.ceilingEntry(A(i))
      if (ceil != null) {
        gt(i) = ceil.getValue
      }
      val floor = tree.floorEntry(A(i))
      if (floor != null) {
        lt(i) = floor.getValue
      }
      tree.put(A(i), i)
    }

    val odd = Array.fill(n)(false)
    val even = Array.fill(n)(false)

    odd(n - 1) = true
    even(n - 1) = true

    for {
      i <- n - 2 to 0 by -1
    } {
      if (gt(i) > i) {
        odd(i) = even(gt(i))
      }
      if (lt(i) > i) {
        even(i) = odd(lt(i))
      }
    }

    (0 until n).count(odd(_))
  }
}
