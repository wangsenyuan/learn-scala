package set800.set840.p849

object Solution {
  def maxDistToClosest(seats: Array[Int]): Int = {
    var j = 0
    var best = 0
    var i = 0
    while (i <= seats.length) {
      if (i == seats.length || seats(i) == 1) {
        val u = i - j
        if (j == 0 || i == seats.length) {
          best = best max u
        } else {
          best = best max ((u + 1) / 2)
        }

        j = i + 1
      }

      i += 1
    }
    best
  }
}
