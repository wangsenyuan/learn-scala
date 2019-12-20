package set1000.set1200.set1250.p1252

object Solution {
  def oddCells(n: Int, m: Int, indices: Array[Array[Int]]): Int = {
    val row = Array.ofDim[Int](n)
    val col = Array.ofDim[Int](m)

    indices.foreach(idx => {
      row(idx(0)) += 1
      col(idx(1)) += 1
    })

    var res = 0

    for {
      i <- 0 until n
      j <- 0 until m
    } {
      val x = row(i) + col(j)
      res += x & 1
    }
    res
  }
}
