package set1000.set1000.set1040.p1040

import scala.util.Sorting

object Solution {
  def numMovesStonesII(stones: Array[Int]): Array[Int] = {
    val n = stones.length
    Sorting.quickSort(stones)
    val x = findMinMoves(stones, n)
    val y = findMaxMoves(stones, n)
    Array(x, y)
  }

  private def findMinMoves(stones: Array[Int], n: Int): Int = {
    var best = Int.MaxValue
    var j = 0
    var i = 0
    while (j < n) {
      while (stones(j) - stones(i) + 1 > n) {
        i += 1
      }
      val x = j - i + 1
      if (x == n - 1 && stones(j) - stones(i) + 1 == n - 1) {
        best = best min 2
      } else {
        best = best min (n - x)
      }
      j += 1
    }
    best
  }

  private def findMaxMoves(stones: Array[Int], n: Int): Int = {
    // the last one is for move the endpoint
    ((stones(n - 1) - stones(1)) max (stones(n - 2) - stones(0))) + 1 - n + 1
  }
}
