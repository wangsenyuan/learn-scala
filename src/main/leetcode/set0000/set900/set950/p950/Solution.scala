package set0000.set900.set950.p950

import scala.util.Sorting

object Solution {
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] = {
    val n = deck.length
    val que = Array.ofDim[Int](n)

    (0 until n).foreach(i => que(i) = i)

    Sorting.quickSort(deck)

    var front = 0
    var end = n

    val ans = Array.ofDim[Int](n)
    for {
      card <- deck
    } {
      val i = que(front)
      ans(i) = card
      front = (front + 1) % n
      que(end % n) = que(front)
      end = (end + 1) % n
      front = (front + 1) % n
    }

    ans
  }

  def deckRevealedIncreasing1(deck: Array[Int]): Array[Int] = {
    val n = deck.length

    Sorting.quickSort(deck)

    val back = Array.ofDim[Int](n)

    def dfs(left: Int, right: Int): Unit = {
      if (left + 1 < right) {
        val m = right - left
        var mid = (left + right) / 2
        if (m % 2 == 1) {
          mid += 1
        }
        dfs(mid, right)

        if (m % 2 == 0) {
          var i = left
          var j = mid
          var k = left
          while (k < right) {
            back(k) = deck(i)
            i += 1
            if (k + 1 < right) {
              back(k + 1) = deck(j)
              j += 1
            }
            k += 2
          }
        } else {
          var i = mid - 1
          var j = right - 2
          var k = right - 1
          while (k > left + 1) {
            back(k) = deck(i)
            i -= 1
            if (k - 1 > left + 1) {
              back(k - 1) = deck(j)
              j -= 1
            }
            k -= 2
          }
          back(left + 1) = deck(right - 1)
          back(left) = deck(left)
        }

        (left until right).foreach(i => deck(i) = back(i))
      }
    }


    dfs(0, n)

    deck
  }
}
