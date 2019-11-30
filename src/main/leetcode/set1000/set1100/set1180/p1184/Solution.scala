package set1000.set1100.set1180.p1184

object Solution {
  def distanceBetweenBusStops(distance: Array[Int], start: Int, destination: Int): Int = {
    if (start == destination) {
      0
    } else {
      val s = distance.sum
      val n = distance.length
      var y = 0
      var x = start

      while ((x + 1) % n != destination) {
        y += distance(x)
        x = (x + 1) % n
      }
      y min (s - y)
    }

  }
}
