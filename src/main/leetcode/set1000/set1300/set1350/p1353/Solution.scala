package set1000.set1300.set1350.p1353

import scala.util.Sorting

object Solution {
  def maxEvents(events: Array[Array[Int]]): Int = {
    if (events.size == 0) {
      0
    } else {
      var INF = 0

      for {
        event <- events
      } {
        INF = INF max event(1)
      }

      INF += 1
      //      val n = events.size
      val arr = Array.fill(2 * INF)(INF)

      def update(pos: Int, v: Int): Unit = {
        var p = pos + INF
        arr(p) = v
        while (p > 0) {
          arr(p >> 1) = arr(p) min arr(p ^ 1)
          p >>= 1
        }
      }

      def query(left: Int, right: Int): Int = {
        var l = left + INF
        var r = right + INF
        var res = INF
        while (l < r) {
          if ((l & 1) == 1) {
            res = res min arr(l)
            l += 1
          }
          if ((r & 1) == 1) {
            r -= 1
            res = res min arr(r)
          }
          l >>= 1
          r >>= 1
        }
        res
      }

      for {
        i <- 0 until INF
      } {
        update(i, i)
      }

      Sorting.quickSort(events)(Ordering.by(_ (1)))

      var res = 0

      for {
        event <- events
      } {
        val start = event(0)
        val end = event(1)
        val p = query(start, end + 1)
        if (p >= start && p <= end) {
          res += 1
          update(p, INF)
        }
      }

      res
    }

  }

}
