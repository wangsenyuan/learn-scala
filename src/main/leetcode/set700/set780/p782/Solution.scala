package set700.set780.p782

object Solution {
  def movesToChessboard(board: Array[Array[Int]]): Int = {
    val n = board.length
    val ans = checkColumns(board, n)

    if (ans < 0) {
      -1
    } else {
      val ans2 = checkRows(board, n)
      if (ans2 < 0) {
        -1
      } else {
        ans + ans2
      }
    }
  }

  private def checkColumns(board: Array[Array[Int]], n: Int): Int = {
    val grid = Array.ofDim[Boolean](n, n)
    var i = 0
    while (i < n) {
      var j = 0
      while (j < n) {
        grid(i)(j) = board(i)(j) == board(i)(0)
        j += 1
      }
      i += 1
    }

    check(grid, n)
  }

  private def checkRows(board: Array[Array[Int]], n: Int): Int = {
    val grid = Array.ofDim[Boolean](n, n)
    var j = 0
    while (j < n) {

      var i = 0
      while (i < n) {
        grid(j)(i) = board(i)(j) == board(0)(j)
        i += 1
      }

      j += 1
    }

    check(grid, n)
  }

  private def check(grid: Array[Array[Boolean]], n: Int): Int = {
    var t = 0
    var f = 0
    var j = 0
    while (j < n) {
      var i = 1
      while (i < n) {
        if (grid(i)(j) != grid(0)(j)) {
          return -1
        }

        i += 1
      }

      if (grid(0)(j)) {
        t += 1
      } else {
        f += 1
      }

      j += 1
    }

    if (n % 2 == 1 && (t - f).abs != 1) {
      return -1
    }

    if (n % 2 == 0 && t != f) {
      return -1
    }

    // a is for first row is true, while b is for false
    var a = 0
    var b = 0
    j = 0
    while(j < n) {
      if(!grid(0)(j)) {
        a += 1
      } else {
        b += 1
      }
      j += 2
    }

    if(t == f) {
      a min b
    } else if(t > f) {
      a
    } else {
      b
    }
  }
}
