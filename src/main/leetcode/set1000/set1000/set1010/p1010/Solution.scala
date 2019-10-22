package set1000.set1000.set1010.p1010

object Solution {
  def numPairsDivisibleBy60(time: Array[Int]): Int = {
    val cnt = Array.ofDim[Int](60)
    for {
      dur <- time
    } {
      cnt(dur % 60) += 1
    }

    var res = 0
    for {
      i <- 1 to 29
    } {
      res += cnt(i) * cnt(60 - i)
    }

    res += (cnt(0) * (cnt(0) - 1)) / 2
    res += (cnt(30) * (cnt(30) - 1)) / 2

    res
  }
}
