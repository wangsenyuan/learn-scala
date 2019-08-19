package set800.set850.p855


object Solution {

  import java.util

  import scala.collection.mutable

  class ExamRoom(_N: Int) {
    val seats = new util.TreeSet[Int]()

    def seat(): Int = {
      if (seats.isEmpty) {
        seats.add(0)
        0
      } else {
        val iter = seats.iterator()
        var prev = iter.next()
        var pos = -1
        var dist = -1

        if (prev != 0) {
          pos = 0
          dist = prev
        }

        while (iter.hasNext) {
          val cur = iter.next()
          val d = cur - prev
          if (d > 1) {
            val hd = d / 2
            if (pos < 0 || hd > dist) {
              pos = prev + hd
              dist = hd
            }
          }
          prev = cur
        }


        if (prev != _N - 1) {
          if (_N - 1 - prev > dist) {
            pos = _N - 1
          }
        }

        seats.add(pos)

        pos
      }
    }

    def leave(p: Int) {
      seats.remove(p)
    }
  }

  class ExamRoom1(_N: Int) {
    val seats = new util.TreeMap[Int, Boolean]()
    val queue = mutable.PriorityQueue[(Int, Int)]()(Ordering.fromLessThan((a, b) => a._2 < b._2 || (a._2 == b._2 && a._1 > b._1)))
    val dist = mutable.Map.empty[Int, Int].withDefaultValue(-1)

    private def putInQueue(pos: Int, minDist: Int): Unit = {
      if (minDist > 0 && (dist(pos) < 0 || minDist < dist(pos))) {
        queue.enqueue(pos -> minDist)
        dist.put(pos, minDist)
      }
    }

    private def prepare(pos: Int): Unit = {
      val before = seats.floorEntry(pos - 1)
      val after = seats.ceilingEntry(pos + 1)
      if (before == null) {
        putInQueue(0, pos)
      } else {
        val x = before.getKey
        val d = (pos - x) / 2
        val y = x + d
        putInQueue(y, d)
      }

      if (after == null) {
        putInQueue(_N - 1, _N - 1 - pos)
      } else {
        val x = after.getKey
        val d = (x - pos) / 2
        val y = pos + d
        putInQueue(y, d)
      }
    }

    putInQueue(0, _N)

    def seat(): Int = {
      var next: (Int, Int) = null
      while (next == null && !queue.isEmpty) {
        val cur = queue.dequeue()
        val (x, d) = cur
        if (dist(x) == d) {
          next = cur
        }
        //        dist -= x
      }

      if (next == null) {
        -1
      } else {
        val pos = next._1
        dist -= pos

        prepare(pos)

        seats.put(pos, true)
        pos
      }
    }

    def leave(p: Int) {
      seats.remove(p)

      if (seats.isEmpty) {
        putInQueue(0, _N)
      } else {
        val before = seats.floorEntry(p)
        val after = seats.ceilingEntry(p)

        if (before == null) {
          putInQueue(0, after.getKey)
        } else {
          val x = before.getKey
          if (after != null) {
            val y = after.getKey
            val d = (y - x) / 2
            putInQueue(x + d, d)
          } else {
            putInQueue(_N - 1, _N - 1 - x)
          }
        }
      }
    }

  }

}
