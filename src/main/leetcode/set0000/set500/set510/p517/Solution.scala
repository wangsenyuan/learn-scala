package set0000.set500.set510.p517

object Solution {
  def findMinMoves(machines: Array[Int]): Int = {
    val total = machines.sum
    val n = machines.length
    if (n == 0 || total % n != 0) {
      -1
    } else {
      // otherwise, it always has a answer
      val avg = total / n
      var left = 0
      var right = total
      var a = 0
      var b = total

      var ans = 0
      for {
        i <- 0 until n
      } {
        b -= avg
        right -= machines(i)
        // a is the required total sum in the left, while b in the right
        if (left <= a && right <= b) {
          // need to flow from cur position to both sides
          ans = ans max (machines(i) - avg)
        } else if (left >= a && right >= b) {
          // need to flow form both sides to cur position
          ans = ans max (left - a) max (right - b)
        } else if (left > a) {
          ans = ans max (left - a)
        } else if (right > b) {
          ans = ans max (right - b)
        }
        a += avg
        left += machines(i)
      }

      ans
    }
  }
}
