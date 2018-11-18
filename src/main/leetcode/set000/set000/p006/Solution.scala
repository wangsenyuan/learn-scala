package set000.set000.p006

object Solution {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) {
      s
    } else if (numRows == 2) {
      twoRows(s)
    } else {
      moreRows(s, numRows)
    }
  }

  def twoRows(s: String): String = {
    val n = s.length
    val res = Array.fill(n)(' ')
    var i = 0
    var j = 0
    while (i < n) {
      res(j) = s(i)
      j += 1
      i += 2
    }

    i = 1
    while (i < n) {
      res(j) = s(i)
      j += 1
      i += 2
    }

    res.mkString
  }

  def moreRows(str: String, numRows: Int): String = {
    val n = str.length
    // col * numRows + (numRows - 2) * col < n
    // 2 * (numRows - 1) * col < n
    var numCols = n / (2 * (numRows - 1))

    if (numCols * 2 * (numRows - 1) < n) {
      numCols += 1
    }

    val colIndexes = Array.fill(numCols)(0)
    val res = Array.fill(n)(' ')
    var j = 0
    var i = 1
    res(j) = str(0)
    j += 1
    while (i < numCols) {
      colIndexes(i) = colIndexes(i - 1) + 2 * (numRows - 1)
      res(j) = str(colIndexes(i))
      j += 1
      i += 1
    }

    var row = 1
    while (row < numRows - 1) {
      var col = 0
      while (col < numCols) {
        colIndexes(col) += 1
        if (colIndexes(col) < n) {
          res(j) = str(colIndexes(col))
          j += 1
          val k = colIndexes(col) + 2 * (numRows - row - 1)
          if (k < n) {
            res(j) = str(k)
            j += 1
          }
        }
        col += 1
      }

      row += 1
    }

    i = 0
    while (i < numCols) {
      colIndexes(i) += 1
      if (colIndexes(i) < n) {
        res(j) = str(colIndexes(i))
        j += 1
      }
      i += 1
    }

    res.mkString
  }
}
