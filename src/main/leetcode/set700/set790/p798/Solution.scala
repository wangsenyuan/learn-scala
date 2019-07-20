package set700.set790.p798

object Solution {
  def bestRotation(A: Array[Int]): Int = {
    val n = A.length
    val dp = Array.ofDim[Int](n)
    var i = 0
    while (i < n) {
      val left = (i - A(i) + 1 + n) % n
      val right = (i + 1) % n
      dp(left) -= 1
      dp(right) += 1
      if (left > right) {
        dp(0) -= 1
      }

      i += 1
    }

    var best = -n
    var k = 0
    var cur = 0
    i = 0
    while(i < n) {
      cur += dp(i)
      if(cur > best) {
        best = cur
        k = i
      }
      i += 1
    }

    k
  }
}
