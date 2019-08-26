package set0000.set700.set790.p799

object Solution {
  def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
    val dp = Array.ofDim[Double](2, 101)
    dp(0)(0) = poured
    var p = 0
    var i = 0
    while(i < query_row) {
      val q = 1 - p

      var j = 0

      while(j <= i) {
        dp(q)(j) = 0
        j += 1
      }

      j = 0
      while(j <= i) {
        if(dp(p)(j) > 1.0) {
          dp(q)(j) += (dp(p)(j) - 1) / 2.0
          dp(q)(j+1) += (dp(p)(j) - 1) / 2.0
        }
        j += 1
      }

      p = q
      i += 1
    }

    dp(p)(query_glass) min 1.0
  }
}
