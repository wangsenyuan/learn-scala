package set300.set350.p352


/**
  * Definition for an interval.
  **/
class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}

class SummaryRanges() {

  /** Initialize your data structure here. */
  val tree = new java.util.TreeMap[Int, Int]()

  def addNum(v: Int) {
    if (!tree.containsKey(v)) {
      val low = tree.lowerEntry(v)

      if (low == null || low.getValue < v) {
        val high = tree.higherEntry(v)

        if (low != null && high != null && low.getValue + 1 == v && v + 1 == high.getKey) {
          //merge
          tree.remove(high.getKey)
          tree.put(low.getKey, high.getValue)
        } else if (low != null && low.getValue + 1 == v) {
          //extend
          tree.put(low.getKey, v)
        } else if (high != null && v + 1 == high.getKey) {
          tree.remove(high.getKey)
          tree.put(v, high.getValue)
        } else {
          tree.put(v, v)
        }
      }
    }
  }

  import scala.collection.mutable.ListBuffer


  def getIntervals(): List[Interval] = {
    val buf = ListBuffer.empty[Interval]
    val iter = tree.entrySet().iterator()
    while (iter.hasNext) {
      val entry = iter.next()
      val key = entry.getKey
      val value = entry.getValue
      buf += new Interval(key, value)
    }
    buf.toList
  }

}
