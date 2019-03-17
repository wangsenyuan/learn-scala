package set400.set440.p440

object Solution {
  def findKthNumber(n: Int, k: Int): Int = {
    val N = n.toLong
    var K = k.toLong - 1
    var res = 1
    while(K > 0) {
      var count = 0L
      var first = res.toLong
      var last = first + 1

      while(first <= N) {
        count += ((N + 1) min last) - first
        first *= 10
        last *= 10
      }

      if(K >= count) {
        res += 1
        K -= count
      } else {
        res *= 10
        K -= 1
      }
    }
    res
  }
}
