package set300.set340.p342

object Solution {
  def isPowerOfFour(num: Int): Boolean = {
    def go(num: Int): Boolean = {
      if (num >= 4) {
        num % 4 == 0 && go(num / 4)
      } else {
        num == 1
      }
    }

    go(num)
  }
}
