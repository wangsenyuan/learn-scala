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

    val mem = Array.fill(n, 2)(0)
    mem(n - 1)(0) = 1
    mem(n - 1)(1) = 1

    def jump(i: Int, step: Int): Boolean = {
      if (mem(i)(step) == 0) {
        val res = if (step == 1 && gt(i) > i) {
          jump(gt(i), 1 - step)
        } else if (step == 0 && lt(i) > i) {
          jump(lt(i), 1 - step)
        } else {
          false
        }
        mem(i)(step) = if (res) {
          1
        } else {
          -1
        }
      }

      mem(i)(step) > 0
    }

    (0 until n).count(jump(_, 1))
  }
}
