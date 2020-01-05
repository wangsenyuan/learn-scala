package set1000.set1300.set1310.p1310

object Solution {
  def xorQueries(arr: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = arr.length
    val sum = Array.ofDim[Int](n + 1)
    (0 until n).foreach(i => {
      sum(i + 1) = sum(i) ^ arr(i)
    })

    queries.map(query => {
      val a = query(0)
      val b = query(1)
      sum(a) ^ sum(b + 1)
    })
  }
}
