package set0000.set100.set110.p119

object Solution {
  def getRow(rowIndex: Int): List[Int] = {
    if (rowIndex == 0) {
      List(1)
    } else {
      val dp = Array.fill(2, rowIndex + 1)(0)
      dp(0)(0) = 1
      var p = 0
      var i = 1
      while (i <= rowIndex) {
        val q = 1 - p
        dp(q)(0) = 1
        dp(q)(i) = 1

        var j = 1
        while (j < i) {
          dp(q)(j) = dp(p)(j - 1) + dp(p)(j)
          j += 1
        }

        p = q
        i += 1
      }
      dp(p).takeWhile(_ != 0).toList
    }
  }
}
