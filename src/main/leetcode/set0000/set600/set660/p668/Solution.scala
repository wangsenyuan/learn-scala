package set0000.set600.set660.p668

object Solution {
  def findKthNumber(m: Int, n: Int, k: Int): Int = {

    def count(x: Int): Int = {
      var res = 0
      (1 to m).foreach(r => {
        res += n min (x / r)
      })
      res
    }

    search(m * n + 1, x => {
      count(x) >= k
    })
  }

  private def search(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
