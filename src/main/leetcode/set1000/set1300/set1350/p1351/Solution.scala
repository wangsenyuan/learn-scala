package set1000.set1300.set1350.p1351

object Solution {
  def countNegatives(grid: Array[Array[Int]]): Int = {
    grid.map(_.count(_ < 0)).sum
  }
}
