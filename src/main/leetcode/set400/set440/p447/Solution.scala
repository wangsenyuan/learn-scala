package set400.set440.p447

import scala.collection.mutable

object Solution {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    val n = points.length
    val cnt = mutable.Map.empty[Long, Int].withDefaultValue(0)

    def distance(i: Int, j: Int): Long = {
      val a = points(i)
      val b = points(j)
      val dx = (a(0) - b(0)).toLong
      val dy = (a(1) - b(1)).toLong

      dx * dx + dy * dy
    }

    var res = 0

    for {
      i <- points.indices
    } {
      cnt.clear()
      for {
        j <- points.indices
        if (i != j)
      } {
        val dist = distance(i, j)
        cnt(dist) += 1
      }

      for {
        (_, c) <- cnt
        if (c > 1)
      } {
        res += c * (c - 1)
      }
    }
    res
  }
}
