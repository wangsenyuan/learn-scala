package set1000.set1200.set1250.p1253

object Solution {
  def reconstructMatrix(upper: Int, lower: Int, colsum: Array[Int]): List[List[Int]] = {
    val n = colsum.length
    val grid = Array.ofDim[Int](2, n)
    val flag = Array.ofDim[Boolean](n)
    var UP = upper
    var LO = lower
    var i = n - 1
    while (i >= 0) {

      flag(i) = colsum(i) != 1
      if (colsum(i) == 2) {
        grid(0)(i) = 1
        grid(1)(i) = 1
        UP -= 1
        LO -= 1
      }
      i -= 1
    }

    if (UP < 0 || LO < 0) {
      Nil
    } else {
      i = 0
      while (i < n && (LO > 0 || UP > 0)) {
        if (!flag(i)) {
          if (UP > 0) {
            grid(0)(i) = 1
            UP -= 1
          } else {
            grid(1)(i) = 1
            LO -= 1
          }
          flag(i) = true
        }
        i += 1
      }
      if (flag.exists(_ == false) || LO > 0 || UP > 0) {
        Nil
      } else {
        grid.map(_.toList).toList
      }
    }
  }
}
