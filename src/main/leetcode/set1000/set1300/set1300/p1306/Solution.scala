package set1000.set1300.set1300.p1306

object Solution {
  def canReach(arr: Array[Int], start: Int): Boolean = {
    val n = arr.length
    val dp = Array.ofDim[Boolean](n)
    val que = Array.ofDim[Int](n)
    var end = 0
    que(end) = start
    end += 1
    dp(start) = true

    var front = 0
    while (front < end && arr(que(front)) != 0) {
      val cur = que(front)
      front += 1
      val x = cur - arr(cur)
      if (x >= 0 && !dp(x)) {
        dp(x) = true
        que(end) = x
        end += 1
      }
      val y = cur + arr(cur)
      if (y < n && !dp(y)) {
        dp(y) = true
        que(end) = y
        end += 1
      }
    }
    front < end && arr(que(front)) == 0
  }
}
