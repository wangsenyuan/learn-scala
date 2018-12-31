package set100.set130.p135

object Solution {
  def candy(ratings: Array[Int]): Int = {
    val n = ratings.size

    val left = Array.fill(n)(1)

    var i = 1
    while (i < n) {
      if (ratings(i) > ratings(i - 1)) {
        left(i) = left(i - 1) + 1
      }
      i += 1
    }

    val right = Array.fill(n)(1)
    i = n - 2
    while (i >= 0) {
      if (ratings(i) > ratings(i + 1)) {
        right(i) = right(i + 1) + 1
      }
      i -= 1
    }

    val height = left.zip(right).map(x => x._1 max x._2)

    height.sum
  }
}
