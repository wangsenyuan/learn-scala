package set0000.set900.set900.p904

import scala.collection.mutable

object Solution {
  def totalFruit(tree: Array[Int]): Int = {
    val n = tree.length
    var best = 0
    val hand = Array.ofDim[Int](4)
    hand(0) = -1
    hand(2) = -1
    var j = 0
    var i = 0
    while (i < n) {
      if (hand(0) >= 0 && hand(2) >= 0 && tree(i) != hand(0) && tree(i) != hand(2)) {
        // the third one
        var can = false
        while (!can) {
          if (hand(0) == tree(j)) {
            hand(1) -= 1
          } else if (hand(2) == tree(j)) {
            hand(3) -= 1
          }
          can = hand(1) == 0 || hand(3) == 0
          j += 1
        }
      }

      if (tree(i) == hand(0)) {
        hand(1) += 1
      } else if (tree(i) == hand(2)) {
        hand(3) += 1
      } else if (hand(1) == 0) {
        hand(0) = tree(i)
        hand(1) += 1
      } else if (hand(3) == 0) {
        hand(2) = tree(i)
        hand(3) += 1
      }

      best = best max (i - j + 1)

      i += 1
    }
    best
  }

  def totalFruit1(tree: Array[Int]): Int = {
    val n = tree.length
    var best = 0

    val hand = mutable.Map.empty[Int, Int].withDefaultValue(0)
    var j = 0
    var i = 0
    while (i < n) {
      hand(tree(i)) += 1

      while (hand.size > 2) {
        if (hand(tree(j)) == 1) {
          hand -= tree(j)
        } else {
          hand(tree(j)) -= 1
        }
        j += 1
      }

      best = best max (i - j + 1)

      i += 1
    }


    best
  }
}
