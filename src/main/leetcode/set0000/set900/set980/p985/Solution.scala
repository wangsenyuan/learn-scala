package set0000.set900.set980.p985

object Solution {
  def sumEvenAfterQueries(A: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = A.length

    val m = queries.length

    val res = Array.ofDim[Int](m)

    var sum = A.filter(_ % 2 == 0).sum

    var i = 0
    while (i < m) {
      val query = queries(i)
      val v = query(0)
      val j = query(1)
      val oldVal = A(j)
      if (oldVal % 2 == 0) {
        sum -= oldVal
      }
      A(j) += v

      if (A(j) % 2 == 0) {
        sum += A(j)
      }

      res(i) = sum

      i += 1
    }

    res
  }
}
