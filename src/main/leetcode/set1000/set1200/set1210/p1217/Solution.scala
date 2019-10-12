package set1000.set1200.set1210.p1217

object Solution {
  def minCostToMoveChips(chips: Array[Int]): Int = {
    var a = 0
    var b = 0
    var i = 0
    while (i < chips.length) {
      if (chips(i) % 2 == 0) {
        a += 1
      } else {
        b += 1
      }

      i += 1
    }

    a min b
  }
}
