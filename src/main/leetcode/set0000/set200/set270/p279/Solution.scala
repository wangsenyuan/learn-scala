package set0000.set200.set270.p279

import scala.collection.mutable

object Solution {
  def numSquares(n: Int): Int = {
    val N = n.toLong
    val sqs = Stream.from(1).map(_.toLong).takeWhile(x => x * x <= N).map(x => x * x).toVector

    val mem = mutable.Map.empty[Long, Int]
    sqs.foreach {
      x => mem += x -> 1
    }

    def go(num: Long): Int = {
      mem.get(num) match {
        case Some(v) => v
        case None =>
          var best = Int.MaxValue
          var x = num / 2
          while (x > 0) {
            val y = num - x
            val cnt = go(x) + go(y)
            best = best min cnt
            x -= 1
          }

          mem += num -> best
          best
      }
    }

    go(n.toLong)
  }
}
