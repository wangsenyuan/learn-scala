package set1000.set1100.set1120.p1128

object Solution {
  def numEquivDominoPairs(dominoes: Array[Array[Int]]): Int = {

    val cnt = Array.ofDim[Int](10, 10)

    for {
      arr <- dominoes
    } {
      if (arr(0) <= arr(1)) {
        cnt(arr(0))(arr(1)) += 1
      } else {
        cnt(arr(1))(arr(0)) += 1
      }
    }

    var res = 0

    for {
      i <- 1 until 10
      j <- i until 10
      if cnt(i)(j) > 1
    } {
      res += cnt(i)(j) * (cnt(i)(j) - 1) / 2
    }

    res
  }
}
