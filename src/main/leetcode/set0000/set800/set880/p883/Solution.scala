package set0000.set800.set880.p883

object Solution {
  def projectionArea(grid: Array[Array[Int]]): Int = {
    var top = 0
    for {
      row <- grid
      cell <- row
    } {
      if (cell > 0) {
        top += 1
      }
    }

    val rows = Array.ofDim[Int](grid.length)
    val cols = Array.ofDim[Int](grid(0).length)

    for {
      i <- 0 until grid.length
      j <- 0 until grid(i).length
    } {
      rows(i) = rows(i) max grid(i)(j)
      cols(j) = cols(j) max grid(i)(j)
    }

    rows.sum + cols.sum + top
  }
}
