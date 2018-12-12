package set000.set060.p060

object Solution {

  private def getFact(n: Int): Array[Int] = {
    val arr = Array.fill(n + 1)(1)
    var i = 1
    while (i <= n) {
      arr(i) = i * arr(i - 1)
      i += 1
    }
    arr
  }

  def getPermutation(n: Int, k: Int): String = {
    val fact = getFact(n)

    def getAns(res: Vector[Int], mask: Int) = {
      var ans = res
      var i = 0
      while (i < n) {
        if ((mask & (1 << i)) == 0) {
          ans :+= (i + 1)
        }
        i += 1
      }
      ans.mkString
    }

    def firstUnUsedNum(mask: Int): Int = {
      (0 until n).find(x => (mask & (1 << x)) == 0).get
    }

    def go(m: Int, k: Int, res: Vector[Int], mask: Int): String = {
      if (k == 1) {
        getAns(res, mask)
      } else {
        var num = firstUnUsedNum(mask)
        var i = num
        var cnt = 0
        while (i < n && cnt < k) {
          if ((mask & (1 << i)) == 0) {
            cnt += fact(m - 1)
            num = i
          }
          i += 1
        }
        cnt -= fact(m - 1)
        go(m - 1, k - cnt, res :+ (num + 1), mask | (1 << num))
      }
    }

    go(n, k, Vector(), 0)
  }
}
