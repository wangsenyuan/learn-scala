package set400.set400.p400

object Solution {
  def findNthDigit(n: Int): Int = {
    val N = n.toLong
    var base = 9L
    var i = 1L
    var cnt = 1L
    var num = 1L
    while(i * base + cnt <= N) {
      cnt += i * base
      num += base
      i += 1
      base *= 10
    }

    //cnt <= n
    val left = N - cnt
    val x = left / i
    val y = (left) % i
    var nn = x + num
    var z = i - y
    var res = 0L
    while(z > 0) {
      res = nn % 10
      nn /= 10
      z -= 1
    }
    res.toInt
  }
}
