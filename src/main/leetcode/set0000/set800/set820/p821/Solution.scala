package set0000.set800.set820.p821

object Solution {
  def shortestToChar(S: String, C: Char): Array[Int] = {
    val n = S.length
    val res = Array.fill(n)(Int.MaxValue >> 1)

    var i = 0
    while(i < n) {
      if(S(i) == C) {
        res(i) = 0
      } else if(i > 0){
        res(i) = res(i - 1) + 1
      }
      i += 1
    }

    i = n - 2
    while(i >= 0) {
      if(S(i) != C) {
        res(i) = res(i) min (res(i + 1) + 1)
      }

      i -= 1
    }

    res
  }
}
