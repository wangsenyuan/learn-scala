package set200.set260.p263

object Solution {
  def isUgly(num: Int): Boolean = {
    val factors = Array(2, 3, 5)

    def go(num: Int, i: Int): Boolean = {
      if (num == 1) {
        true
      } else if (i > 2) {
        false
      } else if (num % factors(i) == 0) {
        go(num / factors(i), i)
      } else {
        go(num, i + 1)
      }
    }

    num > 0 && go(num, 0)
  }
}
