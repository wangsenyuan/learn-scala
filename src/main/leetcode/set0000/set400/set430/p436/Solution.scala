package set0000.set400.set430.p436

/**
  * Definition for an interval.
  * class Interval(var _start: Int = 0, var _end: Int = 0) {
  * var start: Int = _start
  * var end: Int = _end
  * }
  */
object Solution {

  /**
    * Definition for an interval.
    **/
  class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end
  }


  def findRightInterval(intervals: Array[Interval]): Array[Int] = {
    val n = intervals.length
    val tree = new java.util.TreeMap[Int, Int]

    for {
      i <- intervals.indices
    } {
      tree.put(intervals(i).start, i)
    }

    val res = Array.fill(n)(-1)
    for {
      i <- intervals.indices
    } {
      val cap = tree.ceilingEntry(intervals(i).end)
      if (cap != null) {
        res(i) = cap.getValue
      }
    }

    res
  }
}
