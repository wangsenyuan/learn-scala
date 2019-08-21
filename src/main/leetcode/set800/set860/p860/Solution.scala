package set800.set860.p860

object Solution {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    val hand = Array(0, 0)

    var i = 0
    while (i < bills.length) {
      val x = bills(i)
      if (x == 5) {
        hand(0) += 1
      } else if (x == 10) {
        if (hand(0) == 0) {
          return false
        }
        hand(0) -= 1
        hand(1) += 1
      } else {
        // 20
        if (hand(1) > 0 && hand(0) > 0) {
          hand(1) -= 1
          hand(0) -= 1
        } else if (hand(0) >= 3) {
          hand(0) -= 3
        } else {
          return false
        }
      }
      i += 1
    }

    true
  }
}
