package set0000.set000.set050.p056

object Solution {

  def merge(intervals: List[Interval]): List[Interval] = {
    intervals match {
      case Nil => Nil
      case lst =>
        def go(res: Vector[Interval], lst: List[Interval]): Vector[Interval] = {
          lst match {
            case head :: tail =>
              if (!res.isEmpty && overlap(res.last, head)) {
                go(res.init :+ mergeInterval(res.last, head), tail)
              } else {
                go(res :+ head, tail)
              }
            case Nil => res
          }
        }

        val res = go(Vector(), lst.sortBy(_.start))
        res.toList
    }
  }

  private def overlap(a: Interval, b: Interval) = a.end >= b.start

  private def mergeInterval(a: Interval, b: Interval) = new Interval(a.start, a.end max b.end)
}


/**
  * Definition for an interval.
  **/
class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}
