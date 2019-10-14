package set0000.set900.set990.p997

object Solution {
  def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
    val trusts = Array.ofDim[Int](N)
    val beenTrust = Array.ofDim[Int](N)

    for {
      pair <- trust
    } {
      val a = pair(0) - 1
      val b = pair(1) - 1
      trusts(a) += 1
      beenTrust(b) += 1
    }

    var judge = -1
    for {
      i <- 0 until N
    } {
      if (trusts(i) == 0 && beenTrust(i) == N - 1) {
        judge = i
      }
    }

    if (judge < 0) {
      -1
    } else {
      judge + 1
    }
  }
}
