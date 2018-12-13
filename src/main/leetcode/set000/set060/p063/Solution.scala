package set000.set060.p063

object Solution {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    if (obstacleGrid.length == 0) {
      0
    } else if (obstacleGrid(0).length == 0) {
      0
    } else if (obstacleGrid(0)(0) == 1) {
      0
    } else {
      val m = obstacleGrid.length
      val n = obstacleGrid(0).length
      val dp = Array.fill(m, n)(0)
      dp(0)(0) = 1
      var i = 0
      while (i < m) {
        var j = 0
        while (j < n) {
          if (i + 1 < m && obstacleGrid(i + 1)(j) == 0) {
            dp(i + 1)(j) += dp(i)(j)
          }
          if (j + 1 < n && obstacleGrid(i)(j + 1) == 0) {
            dp(i)(j + 1) += dp(i)(j)
          }
          j += 1
        }
        i += 1
      }
      dp(m - 1)(n - 1)
    }
  }
}
