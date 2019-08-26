package set0000.set400.set430.p435



object Solution {
  /**
    * Definition for an interval.
    **/
  class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end
  }
  import scala.util.Sorting

  def eraseOverlapIntervals(intervals: Array[Interval]): Int = {
    Sorting.quickSort(intervals)(new Ordering[Interval](){
      override def compare(x: Interval, y: Interval): Int = {
        if(x.end < y.end) {
          -1
        } else if(x.end > y.end) {
          1
        } else {
          0
        }
      }
    })

    var res = 0
    var i = 1
    var j = 0
    while(i < intervals.length) {
      if(overlap(intervals(j), intervals(i))) {
        res += 1
      } else {
        j = i
      }
      i += 1
    }

    res
  }

  private def overlap(a: Interval, b: Interval): Boolean = {
    a.end > b.start && b.end > a.start
  }
}
