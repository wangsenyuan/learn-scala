package set0000.set700.set760.p768

object Solution {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    val n = arr.length
    val dp = Array.ofDim[Int](n)

    var i = 0
    while(i < n) {
      dp(i) = i
      if(i > 0 && arr(dp(i-1)) > arr(i)) {
        dp(i) = dp(i-1)
      }
      i += 1
    }

    val fp = Array.ofDim[Int](n)
    i = n - 1
    while(i >= 0) {
      fp(i) = i
      if(i < n - 1 && arr(fp(i+1)) < arr(i)) {
        fp(i) = fp(i + 1)
      }
      i -= 1
    }

    i = 0
    var ans = 0
    while(i < n - 1) {
      val a = arr(dp(i))
      val b = arr(fp(i + 1))
      if(a <= b) {
        ans += 1
      }
      i += 1
    }

    ans + 1
  }
}
