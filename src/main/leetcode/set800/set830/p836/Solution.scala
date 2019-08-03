package set800.set830.p836

object Solution {
  def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = {
    val a = rec1(0) max rec2(0)
    val b = rec1(1) max rec2(1)
    val c = rec1(2) min rec2(2)
    val d = rec1(3) min rec2(3)

    a < c && b < d
  }
}
