package set1000.set1000.set1050.p1051

object Solution {
  def heightChecker(heights: Array[Int]): Int = {
    val ss = heights.sorted

    ss.zip(heights).count(x => x._1 != x._2)
  }
}
