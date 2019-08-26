package set0000.set800.set810.p815

import scala.collection.mutable

object Solution {
  def numBusesToDestination(routes: Array[Array[Int]], S: Int, T: Int): Int = {
    if(S == T) {
      0
    } else {
      val n = routes.length

      val outs = Array.ofDim[mutable.Set[Int]](n)

      var i = 0
      while (i < n) {
        outs(i) = mutable.Set.empty[Int]
        i += 1
      }

      val conn = mutable.Map.empty[Int, mutable.Set[Int]]

      i = 0
      while (i < n) {

        for {
          u <- routes(i)
          if conn.contains(u)
          j <- conn(u)
        } {
          outs(i) += j
          outs(j) += i
        }

        for {
          u <- routes(i)
        } {
          if (!conn.contains(u)) {
            conn += u -> mutable.Set.empty[Int]
          }
          conn(u) += i
        }

        i += 1
      }
      if (!conn.contains(S) || !conn.contains(T)) {
        -1
      } else {

        val que = Array.ofDim[Int](n)
        val dist = Array.ofDim[Int](n)
        var front = 0
        var end = 0
        for {
          u <- conn(S)
        } {
          dist(u) = 1
          que(end) = u
          end += 1
        }

        while (front < end) {
          val u = que(front)
          front += 1
          for {
            v <- outs(u)
            if dist(v) == 0
          } {
            dist(v) = dist(u) + 1
            que(end) = v
            end += 1
          }
        }

        val res = conn(T).map(dist).filter(_ > 0)
        if (res.isEmpty) {
          -1
        } else {
          res.min
        }

      }
    }
  }
}
