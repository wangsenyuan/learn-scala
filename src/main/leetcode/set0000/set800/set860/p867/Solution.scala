package set0000.set800.set860.p867

object Solution {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    val m = A.length
    val n = A(0).length
    val B = Array.ofDim[Int](n, m)
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      B(j)(i) = A(i)(j)
    }

    B
  }
}
