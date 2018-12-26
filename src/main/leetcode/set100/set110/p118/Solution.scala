package set100.set110.p118

object Solution {
  def generate(numRows: Int): List[List[Int]] = {
    if (numRows == 0) {
      Nil
    } else {
      val dp = Array.fill(numRows, numRows)(0)
      dp(0)(0) = 1

      for {
        i <- 1 until numRows
      } {
        dp(i)(0) = 1
        dp(i)(i) = 1
        for {
          j <- 1 until i
        } {
          dp(i)(j) = dp(i - 1)(j) + dp(i - 1)(j - 1)
        }
      }

      dp.map(arr => arr.takeWhile(_ != 0).toList).toList
    }
  }
}
