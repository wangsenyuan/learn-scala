package set0000.set700.set730.p731

import java.util

class MyCalendarTwo() {
  val calendarOne = new util.TreeMap[Int, Int]()
  val calendarTwo = new util.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean = {
    val ltTwo = calendarTwo.floorEntry(start)
    if(ltTwo != null && ltTwo.getValue > start) {
      false
    } else {
      // ltTwo == null or ltTwo.value <= start
      val gtTwo = calendarTwo.ceilingEntry(start)
      if(gtTwo != null && gtTwo.getKey < end) {
        false
      } else {
        // gtTwo == null or gtTwo.key >= end
        // start and end can be added
        var x = start
        var y = end
        val ltOne = calendarOne.floorEntry(start)
        if(ltOne != null && ltOne.getValue > start) {
          x = ltOne.getKey
          y = y max ltOne.getValue
          val a = start
          val b = ltOne.getValue min end
          calendarTwo.put(a, b)
          calendarOne.remove(ltOne.getKey)
        }

        var gtOne = calendarOne.ceilingEntry(start)
        while(gtOne != null && end > gtOne.getKey ) {
          y = y max gtOne.getValue
          val a = gtOne.getKey
          val b = end min gtOne.getValue
          calendarTwo.put(a, b)
          calendarOne.remove(gtOne.getKey)
          gtOne = calendarOne.ceilingEntry(gtOne.getValue)
        }

        calendarOne.put(x, y)

        true
      }
    }
  }

}
