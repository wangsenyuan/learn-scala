package set600.set630.p638

object Solution {
  def shoppingOffers(pprice: List[Int], special: List[List[Int]], nneeds: List[Int]): Int = {
    val needs = nneeds.toArray
    val price = pprice.toArray
    val n = price.length
    val ps = Array.ofDim[Int](n + 1)

    ps(0) = 1
    (1 to n).foreach(i => ps(i) = (needs(i - 1) + 1) * ps(i - 1))

    val X = ps(n)


    val dp = Array.fill(X)(Int.MaxValue)

    val arrs = special.map(_.toArray).toArray

    val m = arrs.length


    dp(0) = 0

    val cnt = Array.ofDim[Int](n)
    var state = 0
    while (state < X) {
      if (dp(state) < Int.MaxValue) {
        getCount(state, n, ps, cnt)

        var i = 0
        while (i < n) {
          if (cnt(i) < needs(i)) {
            // need to add one more
            val next = state + ps(i)
            dp(next) = dp(next) min (dp(state) + price(i))
          }
          i += 1
        }

        i = 0
        while (i < m) {
          val arr = arrs(i)
          var next = state
          var fit = true
          val k = arr.length
          val cost = arr(k - 1)
          var j = 0

          while (j < k - 1 && fit) {
            if (arr(j) + cnt(j) <= needs(j)) {
              next += arr(j) * ps(j)
            } else {
              fit = false
            }

            j += 1
          }

          if (fit) {
            dp(next) = dp(next) min (dp(state) + cost)
          }

          i += 1
        }
      }

      state += 1
    }

    dp(X - 1)
  }

  private def getCount(state: Int, n: Int, ps: Array[Int], res: Array[Int]): Unit = {
    var i = 0
    while (i < n) {
      res(i) = state % ps(i+1)
      res(i) /= ps(i)
      i += 1
    }
  }
}
