package set0000.set000.set050.p057


/**
  * Definition for an interval.
  **/
class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}

object Solution {
  def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
    val all = insertInterval(intervals.toArray, newInterval)

    def go(res: Vector[Interval], vec: Vector[Interval]): Vector[Interval] = {
      vec match {
        case head +: tail =>
          if (!res.isEmpty && overlap(res.last, head)) {
            go(res.init :+ mergeInterval(res.last, head), tail)
          } else {
            go(res :+ head, tail)
          }
        case Vector() => res
      }
    }

    val res = go(Vector(), all)

    res.toList
  }

  private def overlap(a: Interval, b: Interval) = a.end >= b.start

  private def mergeInterval(a: Interval, b: Interval) = new Interval(a.start, a.end max b.end)

  private def insertInterval(intervals: Array[Interval], target: Interval): Vector[Interval] = {
    var left = 0
    var right = intervals.length
    while (left < right) {
      val mid = (left + right) / 2
      if (intervals(mid).start >= target.start) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    //intervals(mid).start >= target.start
    // mid is the insert position for target
    val (prev, suf) = intervals.splitAt(right)
    prev.toVector ++ Vector(target) ++ suf
  }
}
