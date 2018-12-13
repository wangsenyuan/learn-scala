package set000.set060.p064

object Solution {

  def minPathSum(grid: Array[Array[Int]]): Int = {
    if(grid.length == 0) {
      0
    } else if(grid(0).length == 0) {
      0
    } else {
      val m = grid.length
      val n = grid(0).length
      val dp = Array.fill(m, n)(Int.MaxValue)
      dp(0)(0) = grid(0)(0)
      var i = 0
      while(i < m){
        var j = 0
        while(j < n) {
          if(i > 0) {
            dp(i)(j) = dp(i)(j) min (dp(i-1)(j) + grid(i)(j))
          }
          if(j > 0) {
            dp(i)(j) = dp(i)(j) min (dp(i)(j-1) + grid(i)(j))
          }
          j += 1
        }
        i += 1
      }
      dp(m-1)(n-1)
    }
  }
}
