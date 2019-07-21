package set800.set800.p801

object Solution {
  def minSwap(A: Array[Int], B: Array[Int]): Int = {
    val n = A.length
    var x = 0
    var y = 1

    var i = 1
    while(i < n) {
      // dp(i)
      var a = Int.MaxValue
      var b = Int.MaxValue
      if(A(i) > A(i-1) && B(i) > B(i-1)) {
        a = a min x
        b = b min (y + 1)
      }
      if(A(i) > B(i-1) && B(i) > A(i-1)) {
        a = a min y
        b = b min (x + 1)
      }
      x = a
      y = b
      i += 1
    }

    x min y
  }
}
