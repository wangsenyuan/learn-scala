package set0000.set700.set760.p765

object Solution {
  def minSwapsCouples(row: Array[Int]): Int = {
    val n = row.length / 2

    val index = Array.ofDim[Int](2 * n)
    var i = 0

    while (i < 2 * n) {
      index(row(i)) = i
      i += 1
    }

    var ans = 0

    val vis = Array.ofDim[Boolean](2 * n)

    def check(x: Int): Int = {
      val a = row(2 * x)
      var b = row(2 * x + 1)
      val c = a ^ 1
      vis(x) = true
      var ans = 0
      while (b != c) {
        val d = b ^ 1
        val j = index(d)
        vis(j / 2) = true
        ans += 1
        b = row(j ^ 1)
      }

      ans
    }


    i = 0
    while (i < n) {
      if (!vis(i)) {
        ans += check(i)
      }

      i += 1
    }

    ans
  }
}
