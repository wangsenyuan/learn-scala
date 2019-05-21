package set600.set670.p679

import scala.collection.mutable

object Solution {
  def judgePoint24(nums: Array[Int]): Boolean = {
    // a + b = 24
    // a * b = 24
    // a / b = 24
    val N = 1 << 4
    val mem = Array.fill[mutable.Set[Double]](N)(null)

    var i = 0
    while (i < N) {
      mem(i) = mutable.Set.empty[Double]
      i += 1
    }

    def loop(num: Double, state: Int): Unit = {
      if (state < N - 1 && !mem(state).contains(num)) {
        mem(state) += num
        var i = 0
        while (i < 4) {
          if ((state & (1 << i)) == 0) {
            loop(num + nums(i).toDouble, state | (1 << i))
            loop(num - nums(i).toDouble, state | (1 << i))
            loop(nums(i).toDouble - num, state | (1 << i))
            loop(num * nums(i).toDouble, state | (1 << i))
            loop(num / nums(i).toDouble, state | (1 << i))

            if (num != 0) {
              loop(nums(i).toDouble / num, state | (1 << i))
            }

          }
          i += 1
        }
      }
    }

    i = 0
    while (i < 4) {
      loop(nums(i), 1 << i)
      i += 1
    }

    var cur = 1
    while (cur < N) {
      val next = (N - 1) ^ cur
      if (next > cur) {
        for {
          a <- mem(cur)
          b <- mem(next)
        } {
          if (abs(a + b - 24) < 0.01) {
            return true
          }
          if (abs(a - b - 24) < 0.01 || abs(b - a - 24) < 0.01) {
            return true
          }

          if (abs(a * b - 24) < 0.01) {
            return true
          }

          if (b != 0 && abs(a / b - 24) < 0.01) {
            return true
          }

          if (a != 0 && abs(b / a - 24) < 0.01) {
            return true
          }
        }
      }
      cur += 1
    }

    return false
  }

  private def abs(num: Double) = num.abs
}
