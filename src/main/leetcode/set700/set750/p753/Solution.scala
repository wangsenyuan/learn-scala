package set700.set750.p753

object Solution {
  def crackSafe(n: Int, k: Int): String = {
    val K = pow(10, n)

    val vis = Array.ofDim[Boolean](K)

    val K1 = K / 10

    val sb = new java.lang.StringBuilder()

    def dfs(cur: Int): Unit = {
      var x = 0
      while(x < k) {
        val y = cur * 10 + x
        if(!vis(y)) {
          vis(y) = true
          dfs(y % K1)
          sb.append(x)
        }
        x += 1
      }
    }

    dfs(0)

    (0 until (n - 1)).foreach(_ => sb.append(0))

    sb.toString
  }

  private def pow(a: Int, b: Int): Int = {
    var res = 1
    var x = a
    var y = b
    while(y > 0) {
      if((y & 1) == 1) {
        res *= x
      }
      x *= x
      y >>= 1
    }
    res
  }
}
