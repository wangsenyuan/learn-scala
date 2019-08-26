package set0000.set500.set520.p528

import scala.util.Random

class Solution(_w: Array[Int]) {
  val n = _w.length
  val W = Array.ofDim[Int](n + 1)

  for {
    i <- _w.indices
  } {
    W(i + 1) = W(i) + _w(i)
  }

  val N = W(n)

  val rand = new Random()

  def pickIndex(): Int = {
    val i = rand.nextInt(N)

    val j = binarySearch(n, W(_) > i)
    // W(j) > i

    j - 1
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
