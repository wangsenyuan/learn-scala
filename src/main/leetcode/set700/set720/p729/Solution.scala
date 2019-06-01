package set700.set720.p729

class MyCalendar() {
  val bookings = new java.util.TreeMap[Int, Int]
  def book(start: Int, end: Int): Boolean = {
    val before = bookings.floorEntry(start)
    if(before != null && before.getValue > start) {
      return false
    }
    val after = bookings.ceilingEntry(start)
    if(after != null && end > after.getKey) {
      return false
    }
    bookings.put(start, end)
    true
  }

}

/**
  * Your MyCalendar object will be instantiated and called as such:
  * var obj = new MyCalendar()
  * var param_1 = obj.book(start,end)
  */
