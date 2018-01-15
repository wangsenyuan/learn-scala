package p048

object Main {

  def rotate(matrix: Array[Array[Int]]): Unit = {

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
