package set0000.set800.set840.p846

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
    Sorting.quickSort(hand)
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)
    hand.foreach(num => cnt(num) += 1)

    var i = 0
    while (i < hand.length) {
      val num = hand(i)
      val c = cnt(num)
      if (c > 0) {
        var x = num
        while (x < num + W && cnt(x) >= c) {
          cnt(x) -= c
          x += 1
        }
        if (x < num + W) {
          return false
        }
      }
      i += 1
    }
    true
  }
}
