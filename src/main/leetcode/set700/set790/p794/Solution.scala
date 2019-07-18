package set700.set790.p794

object Solution {
  def validTicTacToe(board: Array[String]): Boolean = {
    // 0 for empty, 1 for X, -1 for O
    var sum = 0
    for {
      i <- 0 until 3
      j <- 0 until 3
    } {
      if(board(i)(j) == 'X') {
        sum += 1
      } else if(board(i)(j) == 'O') {
        sum -= 1
      }
    }

    if(sum < 0 || sum > 1) {
      false
    } else {
      val xWin = check('X', board)
      val oWin = check('O', board)
      if(xWin && oWin) {
        false
      } else if(xWin) {
        sum == 1
      } else if(oWin) {
        sum == 0
      } else {
        true
      }
    }
  }

  private def check(s: Char, board: Array[String]): Boolean = {
    def checkRow() = {
      var i = 0
      var win = false
      while(i < board.length && !win) {
        win = board(i)(0) == s && board(i)(1) == s && board(i)(2) == s
        i += 1
      }
      win
    }

    def checkCol() = {
      var j = 0
      var win = false
      while(j < 3 && !win) {
        win = board(0)(j) == s && board(1)(j) == s && board(2)(j) == s
        j += 1
      }
      win
    }

    def check1() = {
      board(0)(0) == s && board(1)(1) == s && board(2)(2) == s
    }

    def check2() = {
      board(0)(2) == s && board(1)(1) == s && board(2)(0) == s
    }

    checkRow() || checkCol() || check1() || check2()
  }
}
