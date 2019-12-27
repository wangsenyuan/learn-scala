package set1000.set1200.set1270.p1275

object Solution {
  def tictactoe(moves: Array[Array[Int]]): String = {
    val row = Array.ofDim[Int](3)
    val col = Array.ofDim[Int](3)
    var diag0 = 0
    var diag1 = 0

    def checkWin(x: Int, y: Int, v: Int): String = {
      row(x) += v
      col(y) += v
      if (x == y) {
        diag0 += v
      }
      if (x + y == 2) {
        diag1 += v
      }
      if (row(x).abs == 3 || col(y).abs == 3 || diag0.abs == 3 || diag1.abs == 3) {
        if (v == 1) {
          "A"
        } else {
          "B"
        }
      } else {
        "Draw"
      }
    }

    var res = "Draw"
    var i = 0
    while (i < moves.length && i < 9 && res == "Draw") {
      val x = moves(i)(0)
      val y = moves(i)(1)
      val v = if (i % 2 == 0) {
        1
      } else {
        -1
      }

      res = checkWin(x, y, v)

      i += 1
    }

    if (res == "Draw" && i < 9) {
      "Pending"
    } else {
      res
    }
  }
}
