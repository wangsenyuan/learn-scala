package set400.set400.p402

object Solution {
  def removeKdigits(num: String, k: Int): String = {
    val n = num.length
    val pos = Array.ofDim[Int](10, n)
    for {
      i <- 0 until 10
    } {
      pos(i)(n-1) = n
    }
    pos(num(n-1) - '0')(n-1) = n - 1

    for {
      i <- n - 2 to 0 by -1
    } {
      for {
        j <- 0 until 10
      } {
        pos(j)(i) = pos(j)(i+1)
      }
      pos(num(i) - '0')(i) = i
    }

    val buf = new StringBuilder()

    def go(i: Int, cnt: Int): Unit = {
      if(i < n) {
        val x = num(i) - '0'

        val nxt = (0 until x).find(y => pos(y)(i) - i <= cnt)
        nxt match {
          case Some(j) => go(pos(j)(i), cnt - (pos(j)(i) - i))
          case None =>
            buf.append(x)
            go(i + 1, cnt)
        }
      }
    }
    go(0, k)

    var res = buf.toString()
    var i = 0
    while(i < res.length && res(i) == '0') {
      i += 1
    }
    res = res.substring(i)
    if(res.isEmpty) {
      "0"
    } else {
      res
    }
  }
}
