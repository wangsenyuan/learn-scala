package set0000.set100.set120.p120

object Solution {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val n = triangle.length
    if (n == 0) {
      0
    } else {
      val nums = Array.fill(2, n)(0)
      nums(0)(0) = triangle.head.head

      def sumRow(row: List[Int], q: Int, i: Int): Unit = {
        row match {
          case h :: tail =>
            if (i == 0) {
              nums(q)(i) = h + nums(1 - q)(i)
            } else if (tail.isEmpty) {
              nums(q)(i) = h + nums(1 - q)(i - 1)
            } else {
              nums(q)(i) = h + (nums(1 - q)(i) min nums(1 - q)(i - 1))
            }
            sumRow(tail, q, i + 1)
          case Nil =>
        }
      }

      def go(list: List[List[Int]], p: Int): Array[Int] = {
        list match {
          case head :: tail =>
            sumRow(head, 1 - p, 0)
            go(tail, 1 - p)
          case Nil => nums(p)
        }
      }

      go(triangle.tail, 0).min
    }
  }
}
