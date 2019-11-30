package set1000.set1100.set1170.p1177

object Solution {
  def canMakePaliQueries(s: String, queries: Array[Array[Int]]): Array[Boolean] = {
    val n = s.length
    val cnts = Array.ofDim[Int](n + 1, 26)
    var i = 0
    while (i < n) {
      var j = 0
      while (j < 26) {
        cnts(i + 1)(j) = cnts(i)(j)
        j += 1
      }
      cnts(i + 1)(s(i) - 'a') += 1
      i += 1
    }

    def check(query: Array[Int]): Boolean = {
      val left = query(0)
      val right = query(1) + 1
      val k = query(2)

      var x = 0
      var j = 0
      while (j < 26) {
        val d = cnts(right)(j) - cnts(left)(j)
        x += d & 1
        j += 1
      }
      x / 2 <= k
    }

    val m = queries.length
    val ans = Array.ofDim[Boolean](m)
    i = 0
    while (i < m) {
      ans(i) = check(queries(i))
      i += 1
    }

    ans
  }
}
