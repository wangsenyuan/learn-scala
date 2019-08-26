package set0000.set800.set870.p871

import scala.collection.mutable

object Solution {
  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
    val pq = mutable.PriorityQueue.empty[Int]
    var has = startFuel
    var stops = 0
    var curPos = 0
    var i = 0
    while (i < stations.length && has >= 0) {
      // i is the next stations
      while (stations(i)(0) - curPos > has && !pq.isEmpty) {
        stops += 1
        has += pq.dequeue()
      }
      has -= stations(i)(0) - curPos
      curPos = stations(i)(0)
      pq.enqueue(stations(i)(1))
      i += 1
    }

    if (has < 0) {
      -1
    } else {
      while (target - curPos > has && !pq.isEmpty) {
        stops += 1
        has += pq.dequeue()
      }
      if (target - curPos <= has) {
        stops
      } else {
        -1
      }
    }
  }
}
