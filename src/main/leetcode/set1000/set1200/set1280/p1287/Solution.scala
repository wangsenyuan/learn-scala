package set1000.set1200.set1280.p1287

object Solution {
  def findSpecialInteger(arr: Array[Int]): Int = {
    val n = arr.length
    var j = 0
    var i = 0
    while (i <= n) {
      if (i == n || arr(i) > arr(i - 1)) {
        val cnt = i - j
        if (4 * cnt > n) {
          return arr(j)
        }
        j = i
      }
      i += 1
    }
    0
  }
}
