package set0000.set400.set410.p419

object Solution {
  def countBattleships(board: Array[Array[Char]]): Int = {
    var res = 0
    for {
      i <- 0 until board.length
      j <- 0 until board(i).length
    } {
      if(board(i)(j) == 'X') {
        // first row or column
        if(i > 0 && board(i-1)(j) == 'X') {
          // part of the previous vet ship
        } else if(j > 0 && board(i)(j-1) == 'X') {
          // part of the previous hoz ship
        } else {
          res += 1
        }
      }
    }
    res
  }
}
