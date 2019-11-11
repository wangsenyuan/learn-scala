package set1000.set1000.set1080.p1089

object Solution {
  def duplicateZeros(arr: Array[Int]): Unit = {
    var n = 0
    var i = 0
    while (i < arr.length && n < arr.length) {
      if (arr(i) == 0) {
        n += 2
      } else {
        n += 1
      }
      i += 1
    }

    if(n > arr.length) {
      // last one is 0
      arr(n - 2) = 0
      n -= 2
      i -= 1
    }

    while (i > 0) {
      arr(n - 1) = arr(i - 1)
      n -= 1
      if (arr(i - 1) == 0) {
        arr(n - 1) = 0
        n -= 1
      }

      i -= 1
    }
  }
}
