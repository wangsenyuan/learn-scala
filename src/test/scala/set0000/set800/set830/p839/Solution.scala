package set0000.set800.set830.p839

object Solution {
  def numSimilarGroups(A: Array[String]): Int = {
    val cnt = Array.ofDim[Int](26)

    def checkSimilar(x: Int, y: Int): Boolean = {
      val a = A(x)
      val b = A(y)
      var j = -1
      var k = -1
      var i = 0
      var lessThreeDifferent = true
      while (i < a.length && lessThreeDifferent) {
        if (a(i) != b(i)) {
          if (j == -1) {
            j = i
          } else if (k == -1) {
            k = i
          } else {
            lessThreeDifferent = false
          }
        }
        i += 1
      }
      if (!lessThreeDifferent) {
        false
      } else if (j == -1) {
        (0 until 26).foreach(c => cnt(c) = 0)
        a.foreach(c => cnt(c - 'a') += 1)
        cnt.exists(_ >= 2)
      } else {
        k != -1
      }
    }

    val n = A.length
    val similar = Array.ofDim[Boolean](n, n)

    for {
      i <- 0 until n
      j <- (i + 1) until n
    } {
      val r = checkSimilar(i, j)
      similar(i)(j) = r
      similar(j)(i) = r
    }

    val labels = Array.ofDim[Int](n)

    def dfs(u: Int, label: Int): Unit = {
      if(labels(u) < label) {
        labels(u) = label
        for {
          v <- 0 until n
          if(similar(u)(v))
        } {
          dfs(v, label)
        }
      }
    }

    var label = 1
    var u = 0
    while(u < n) {
      if(labels(u) == 0) {
        dfs(u, label)
        label += 1
      }
      u += 1
    }

    label - 1
  }
}
