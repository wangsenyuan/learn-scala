package set0000.set800.set810.p818

import scala.collection.mutable

object Solution {
  def racecar(target: Int): Int = {
    val K = 33 - Integer.numberOfLeadingZeros(target - 1)
    val barrier = 1 << K
    val dist = Array.fill(2 * barrier + 1)(Int.MaxValue)
    dist(target) = 0

    val pq = mutable.PriorityQueue.empty[(Int, Int)](Ordering.fromLessThan(compareNode))
    pq.enqueue(0 -> target)

    while(!pq.isEmpty) {
      val node = pq.dequeue()
      val steps = node._1
      val targ1 = node._2
      if(dist(Math.floorMod(targ1, dist.length)) <= steps) {
        for {
          k <- 0 to K
        } {
          val walk = (1 << k) - 1
          val targ2 = walk - targ1
          val steps2 = if(targ2 == 0) {
              steps + k
            } else {
              steps + k + 1
            }
          if(targ2.abs <= barrier && steps2 < dist(Math.floorMod(targ2, dist.length))) {
            pq.enqueue(steps2 -> targ2)
            dist(Math.floorMod(targ2, dist.length)) = steps2
          }

        }
      }
    }
    dist(0)
  }

  private def compareNode(a: (Int, Int), b: (Int, Int)): Boolean = {
    a._1 > b._1
  }

  def racecar1(target: Int): Int = {
    val dp = Array.fill(target + 3)(Int.MaxValue)
    dp(0) = 0
    dp(1) = 1
    dp(2) = 4

    for {
      t <- 3 to target
    } {
      val k = 32 - Integer.numberOfLeadingZeros(t)
      if (t == (1 << k) - 1) {
        dp(t) = k
      } else {
        for {
          j <- 0 until (k - 1)
        } {
          dp(t) = dp(t) min (dp(t - (1 << (k - 1)) + (1 << j)) + k - 1 + j + 2)
        }

        if ((1 << k) - 1 - t < t) {
          dp(t) = dp(t) min (dp((1 << k) - 1 - t) + k + 1)
        }
      }
    }

    dp(target)
  }
}
