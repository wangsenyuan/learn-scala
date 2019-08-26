package set0000.set600.set680.p688

object Solution {
  val dx = Array(-2, -2, -1, 1, 2, 2, 1, -1)
  val dy = Array(-1, 1, 2, 2, 1, -1, -2, -2)

  def knightProbability(N: Int, K: Int, r: Int, c: Int): Double = {
    var dp = Array.ofDim[Double](N, N)
    dp(r)(c) = 1.0
    var fp = Array.ofDim[Double](N, N)
    var k = 0
    while (k < K) {
      clear(fp)

      var i = 0
      while (i < N) {
        var j = 0

        while (j < N) {
          if (dp(i)(j) > 0) {
            var l = 0
            while (l < 8) {
              val u = i + dx(l)
              val v = j + dy(l)
              if (u >= 0 && u < N && v >= 0 && v < N) {
                fp(u)(v) += 0.125 * dp(i)(j)
              }
              l += 1
            }

          }

          j += 1
        }

        i += 1
      }

      val ep = dp
      dp = fp
      fp = ep
      k += 1
    }

    dp.map(_.sum).sum
  }

  private def clear(array: Array[Array[Double]]): Unit = {
    (0 until array.length).foreach(i => (0 until array(i).length).foreach(j => array(i)(j) = 0))
  }
}
