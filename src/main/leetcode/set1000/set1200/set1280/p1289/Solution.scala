package set1000.set1200.set1280.p1289

object Solution {
  def minFallingPathSum(arr: Array[Array[Int]]): Int = {
    var res = 0
    var i = 0
    do {
      val row = arr(i)
      var first = -1
      var second = -1

      var j = 0
      while (j < row.length) {
        if (first < 0 || row(j) < row(first)) {
          second = first
          first = j
        } else if (second < 0 || row(j) < row(second)) {
          second = j
        }

        j += 1
      }

      res = row(first)

      if (i < arr.length - 1) {
        j = 0
        while (j < row.length) {
          if (j != first) {
            arr(i + 1)(j) += row(first)
          } else {
            arr(i + 1)(j) += row(second)
          }
          j += 1
        }
      }

      i += 1
    } while (i < arr.length)

    res
  }
}
