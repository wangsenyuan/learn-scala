package set800.set860.p861

object Solution {
  def matrixScore(A: Array[Array[Int]]): Int = {
    if (A.length == 0 || A(0).length == 0) {
      0
    } else {
      // 翻转第一列，1 -> 0, 0 -> 1, 并翻转所有第一个数字是1个行
      val row = Array.ofDim[Boolean](A.length)
      for {
        i <- 0 until A.length
      } {
        row(i) = 1 == A(i)(0)
      }
      val a = calc(A, row, true)

      for {
        i <- 0 until A.length
      } {
        row(i) = 0 == A(i)(0)
      }
      val b = calc(A, row, false)

      a max b
    }

  }

  private def calc(A: Array[Array[Int]], row: Array[Boolean], firstCol: Boolean): Int = {
    val n = A.length

    val col = Array.ofDim[Boolean](A(0).length)
    col(0) = firstCol

    for {
      j <- 1 until A(0).length
    } {
      var cnt = 0
      for {
        i <- 0 until n
      } {
        if (row(i)) {
          cnt += 1 - A(i)(j)
        } else {
          cnt += A(i)(j)
        }
      }

      col(j) = 2 * cnt < n
    }

    var res = 0
    for {
      i <- 0 until n
    } {
      var num = 0
      for {
        j <- 0 until A(0).length
      } {

        val x =
          if (row(i) == col(j)) {
            // flip both or none
            A(i)(j)
          } else {
            1 - A(i)(j)
          }
        if (x == 1) {
          num |= 1 << (A(0).length - 1 - j)
        }
      }

      res += num
    }
    res
  }

}
