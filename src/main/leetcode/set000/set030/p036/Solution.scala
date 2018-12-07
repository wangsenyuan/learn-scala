package set000.set030.p036

object Solution {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val rows = Array.fill(9)(0)
    val cols = Array.fill(9)(0)
    val cells = Array.fill(9)(0)

    def isValid(i: Int, j: Int): Boolean = {
      val num = board(i)(j) - '0'
      val mask = 1 << num
      if ((rows(i) & mask) > 0) {
        false
      } else if ((cols(j) & mask) > 0) {
        false
      } else if ((cells(i / 3 * 3 + j / 3) & mask) > 0) {
        false
      } else {
        true
      }
    }

    def go(i: Int, j: Int): Boolean = {
      if (i == 9) {
        true
      } else if (board(i)(j) == '.' || isValid(i, j)) {
        if (board(i)(j) != '.') {
          val num = board(i)(j) - '0'
          rows(i) |= 1 << num
          cols(j) |= 1 << num
          cells(i / 3 * 3 + j / 3) |= 1 << num
        }
        if (j == 8) {
          go(i + 1, 0)
        } else {
          go(i, j + 1)
        }
      } else {
        false
      }
    }

    go(0, 0)
  }
}
