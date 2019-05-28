package set700.set710.p718

object Solution {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    val m = A.length
    val n = A.length

    val dp = Array.ofDim[Int](m+1, n+1)

    var res = 0

    var i = m - 1
    while(i >= 0) {
      var j = n - 1
      while(j >= 0) {
        if(A(i) == B(j)) {
          dp(i)(j) = dp(i+1)(j+1) + 1
        }

        res = res max dp(i)(j)

        j -= 1
      }

      i -= 1
    }

    res
  }
}
