package set0000.set400.set460.p463

object Solution {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    var a = 0
    var b = 0
    for {
      i <- grid.indices
      j <- grid(i).indices
    } {
      if (grid(i)(j) == 1) {
        a += 1
        if (i > 0 && grid(i - 1)(j) == 1) {
          b += 1
        }
        if (j > 0 && grid(i)(j - 1) == 1) {
          b += 1
        }
      }
    }

    a * 4 - b * 2
  }
}
