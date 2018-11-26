package set000.set000.p009

object Solution {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) {
      false
    } else if (x == 0) {
      true
    } else {
      reverse(x) == x
    }
  }

  private def reverse(num: Int): Int = {
    def go(x: Int, curr: Long): Long = {
      if (x == 0) {
        curr
      } else {
        val y = curr * 10 + x % 10
        if (y > Int.MaxValue) {
          -1
        } else {
          go(x / 10, y)
        }
      }
    }

    go(num, 0).toInt
  }
}
