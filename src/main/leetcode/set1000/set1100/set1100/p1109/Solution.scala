package set1000.set1100.set1100.p1109

object Solution {
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val res = Array.ofDim[Int](n)
    for {
      booking <- bookings
    } {
      val i = booking(0) - 1
      val j = booking(1)
      val k = booking(2)
      res(i) += k
      if (j < n) {
        res(j) -= k
      }
    }
    for {
      i <- 1 until n
    } {
      res(i) += res(i - 1)
    }
    res
  }
}
