package set0000.set200.set250.p258

object Solution {
  def addDigits(num: Int): Int = {
    if (num == 0) {
      0
    } else {
      1 + (num - 1) % 9
    }
  }
}
