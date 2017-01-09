package codechef.easy.commute

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/12/2016.
  */
object Main {

  case class Station(x: Int, l: Int, f: Int)

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      var n = StdIn.readInt()
      var stations = Vector.empty[Station]
      while (n > 0) {
        n -= 1
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        stations :+= Station(line(0), line(1), line(2))
      }

      val res = travel(stations)

      println(res)
    }
  }

  def travel(stations: Vector[Station]): Int = {

    def nextLeaveTime(station: Station, took: Int): Int = {
      var i = 0
      while (station.x + i * station.f < took) {
        i += 1
      }
      station.x + i * station.f
    }

    @tailrec
    def go(left: Vector[Station], arriveAt: Int): Int = {
      left match {
        case Vector() => arriveAt
        case s +: tail =>
          val leaveTime = nextLeaveTime(s, arriveAt)
          go(tail, leaveTime + s.l)
      }
    }

    go(stations, 0)
  }
}
