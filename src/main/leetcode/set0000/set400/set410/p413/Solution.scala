package set0000.set400.set410.p413

object Solution {
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    val n = A.length
    var i = 0
    var res = 0
    while(i < n - 2) {
      val a = A(i)
      val b = A(i+1)
      val diff = b - a
      var j = i + 2
      while(j < n && A(j) - A(j-1) == diff) {
        j += 1
      }
      // [i....j) is arithmetic
      if(j > i + 2) {
        res += (j - i - 2) * (j - i - 1) / 2
      }
      i = j - 1
    }
    res
  }
}
