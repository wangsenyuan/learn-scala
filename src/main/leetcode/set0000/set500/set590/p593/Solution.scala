package set0000.set500.set590.p593

object Solution {
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
    val ps = Array(p1, p2, p3, p4)
    val ds = for {
      i <- 0 until 4
      j <- i + 1 until 4
    } yield {
      distance(ps(i), ps(j))
    }
    // c(4, 2) = 4 * 3 / 2 = 6
    val ss = ds.sorted
    val first = ss(0)
    val last = ss(5)
    if (first == 0) {
      false
    } else if (first * 2 != last) {
      false
    } else {
      if (ss(1) != first || ss(2) != first || ss(3) != first) {
        false
      } else if (ss(4) != last) {
        false
      } else {
        true
      }
    }
  }

  private def distance(a: Array[Int], b: Array[Int]): Int = {
    val dx = a(0) - b(0)
    val dy = a(1) - b(1)
    dx * dx + dy * dy
  }
}
