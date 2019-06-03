package set700.set730.p732

import scala.collection.mutable

class MyCalendarThree() {
  val bookings = new java.util.TreeMap[Int, Int]()
  val count = mutable.Map.empty[Int, Int].withDefaultValue(0)
  var ans = 1

  def book(start: Int, end: Int): Int = {
    val lt = bookings.floorEntry(start)

    var pos = start
    if (lt != null && lt.getValue > start) {
      val cc = count(lt.getKey)
      if (lt.getKey < start) {
        bookings.put(lt.getKey, start)
      }

      pos = lt.getValue min end

      bookings.put(start, pos)
      count += start -> (1 + cc)
      ans = ans max (count(start))

      if (pos < lt.getValue) {
        bookings.put(pos, lt.getValue)
        count += pos -> cc
        pos = lt.getValue
      }
    }


    var gt = bookings.ceilingEntry(pos)
    while (gt != null && gt.getKey < end) {
      if (pos < gt.getKey) {
        bookings.put(pos, gt.getKey)
        count += pos -> 1
      }

      val next = gt.getValue min end
      bookings.put(gt.getKey, next)
      val cc = count(gt.getKey)
      count += gt.getKey -> (cc + 1)

      ans = ans max (cc + 1)

      if (next < gt.getValue) {
        bookings.put(next, gt.getValue)
        count += next -> cc
      }
      pos = gt.getValue
      gt = bookings.ceilingEntry(pos)
    }
    if (pos < end) {
      bookings.put(pos, end)
      count += pos -> 1
    }
    ans
  }

}

/**
  * Your MyCalendarThree object will be instantiated and called as such:
  * var obj = new MyCalendarThree()
  * var param_1 = obj.book(start,end)
  */
