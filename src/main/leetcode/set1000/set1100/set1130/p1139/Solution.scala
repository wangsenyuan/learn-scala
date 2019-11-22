package set1000.set1100.set1130.p1139

object Solution {
  def largest1BorderedSquare(grid: Array[Array[Int]]): Int = {

    def check(i: Int, j: Int, w: Int): Boolean = {
      var k = i
      while (k < i + w && grid(k)(j) == 1 && grid(k)(j + w - 1) == 1) {
        k += 1
      }
      if (k < i + w) {
        false
      } else {
        k = j
        while (k < j + w && grid(i)(k) == 1 && grid(i + w - 1)(k) == 1) {
          k += 1
        }
        k == j + w
      }
    }

    var best = 0

    for {
      i <- 0 until grid.length
      j <- 0 until grid(0).length
    } {
      val m = (grid.length - i) min (grid(0).length - j)
      var x = m
      while (x > 0 && !check(i, j, x)) {
        x -= 1
      }
      best = best max x * x
    }

    best
  }
}
