package set300.set380.p386

object Solution {
  def lexicalOrder(n: Int): List[Int] = {
    val res = Array.ofDim[Int](n)

    var cur = 1
    var i = 0
    while (i < n) {
      res(i) = cur

      if (cur * 10 <= n) {
        cur *= 10
      } else if (cur < n && cur % 10 < 9) {
        cur += 1
      } else {
        while ((cur / 10) % 10 == 9) {
          cur /= 10
        }
        cur = cur / 10 + 1
      }

      i += 1
    }

    res.toList
  }

  def lexicalOrder1(n: Int): List[Int] = {

    val res = Array.ofDim[Int](n)
    var j = 0

    def go(cur: Int): Unit = {
      if (cur <= n) {
        res(j) = cur
        j += 1
        var i = 0
        while (i < 10) {
          go(cur * 10 + i)
          i += 1
        }
      }
    }

    var i = 1
    while (i <= n & i < 10) {
      go(i)
      i += 1
    }

    res.toList
  }
}
