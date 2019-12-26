package set1000.set1200.set1260.p1266

object Solution {
  def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = {
    var res = 0
    var i = 1
    while (i < points.length) {
      val a = points(i - 1)(0)
      val b = points(i - 1)(1)
      val c = points(i)(0)
      val d = points(i)(1)
      val dx = (c - a).abs
      val dy = (d - b).abs
      res += (dx min dy) + ((dx max dy) - (dx min dy))

      i += 1
    }

    res
  }
}
