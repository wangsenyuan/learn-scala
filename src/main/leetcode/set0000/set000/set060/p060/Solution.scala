package set0000.set000.set060.p060

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
      val ans = res ++ (findUnUsedNums(mask).map(_ + 1))
      ans.mkString
    }

    def findUnUsedNums(mask: Int): Seq[Int] = {
      (0 until n).filter(x => (mask & (1 << x)) == 0)
    }

    def go(m: Int, k: Int, res: Vector[Int], mask: Int): String = {
      if (k == 1) {
        getAns(res, mask)
      } else {
        val nums = findUnUsedNums(mask)
        var i = 0
        val cnt = fact(m - 1)
        while (i * cnt < k) {
          i += 1
        }
        // i * cnt >= k
        i -= 1
        val num = nums(i)

        go(m - 1, k - i * cnt, res :+ (num + 1), mask | (1 << num))
      }
    }

    go(n, k, Vector(), 0)
  }
}
