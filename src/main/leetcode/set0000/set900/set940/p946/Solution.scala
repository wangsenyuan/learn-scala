package set0000.set900.set940.p946

object Solution {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val n = pushed.length

    if (n == 0) {
      true
    } else {
      val stack = Array.ofDim[Int](n)
      var p = 0
      var i = 0
      var j = 0

      while (i < n) {
        stack(p) = pushed(i)
        p += 1
        while (j < n && p > 0 && stack(p - 1) == popped(j)) {
          j += 1
          p -= 1
        }
        i += 1
      }

      while (j < n && p > 0 && stack(p - 1) == popped(j)) {
        j += 1
        p -= 1
      }

      i == n && j == n
    }
  }
}
