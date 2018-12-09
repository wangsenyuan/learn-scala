package set000.set040.p048

object Solution {

  def rotate(matrix: Array[Array[Int]]): Unit = {
    val n = matrix.size
    if (n >= 2) {
      var a = 0
      var b = n - 1
      while (a < b) {
        var i = a
        while (i < b) {
          val x = matrix(a)(i)
          matrix(a)(i) = matrix(b - (i - a))(a)
          matrix(b - (i - a))(a) = matrix(b)(b - (i - a))
          matrix(b)(b - (i - a)) = matrix(i)(b)
          matrix(i)(b) = x
          i += 1
        }

        a += 1
        b -= 1
      }
    }
  }

  def rotate1(matrix: Array[Array[Int]]): Unit = {

    def fn(i: Int, w: Int): Unit = {
      if (w >= 2) {
        fn(i + 1, w - 2)
        for {
          k <- 0 until w - 1
          j = i + k
        } {
          val x = matrix(i)(j)
          matrix(i)(j) = matrix(i + w - 1 - k)(i)
          matrix(i + w - 1 - k)(i) = matrix(i + w - 1)(i + w - 1 - k)
          matrix(i + w - 1)(i + w - 1 - k) = matrix(j)(i + w - 1)
          matrix(j)(i + w - 1) = x
        }
      }
    }

    fn(0, matrix.size)
  }
}
