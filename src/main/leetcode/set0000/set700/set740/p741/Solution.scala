package set0000.set700.set740.p741

object Solution {
  def cherryPickup(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0 || grid(0).length == 0) {
      0
    } else {
      val n = grid.length
      val MINF = Int.MinValue >> 1

      val dp = Array.fill(n, n)(MINF)
      dp(0)(0) = grid(0)(0)
      val dp2 = Array.fill(n, n)(MINF)
      var t = 1
      while(t <= 2 * n - 2) {
        (0 until n) foreach(i => (0 until n) foreach (j => dp2(i)(j) = MINF))

        var i = 0 max (t - (n - 1))
        while(i <= ((n - 1) min t)) {
          var j = 0 max (t - (n - 1))
          while(j <= ((n - 1) min t)) {
            val c1 = t - i
            val c2 = t - j

            if(grid(i)(c1) != -1 && grid(j)(c2) != -1) {
              var v = grid(i)(c1)
              if(i != j) {
                v += grid(j)(c2)
              }
              var pi = i - 1
              while(pi <= i) {
                var pj = j - 1
                while(pj <= j) {
                  if(pi >= 0 && pj >= 0) {
                    dp2(i)(j) = dp2(i)(j) max (dp(pi)(pj) + v)
                  }

                  pj += 1
                }

                pi += 1
              }
            }

            j += 1
          }

          i += 1
        }

        (0 until n) foreach(i => (0 until n) foreach (j => dp(i)(j) = dp2(i)(j)))

        t += 1
      }


      0 max dp(n - 1)(n - 1)
    }
  }
}
