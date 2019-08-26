package set0000.set600.set630.p638

object Solution {

  def getCount(cnt: Array[Int], state: Int, n: Int) = {
    var tmp = state
    var i = 0
    while (i < n) {
      cnt(i) = tmp % 7
      tmp /= 7
      i += 1
    }
  }

  def shoppingOffers(pprice: List[Int], special: List[List[Int]], nneeds: List[Int]): Int = {
    val needs = nneeds.toArray
    val price = pprice.toArray
    val n = price.length
    val ps = Array.ofDim[Int](n + 1)

    ps(0) = 1
    (1 to n).foreach(i => ps(i) = 7 * ps(i - 1))

    val X = (0 until n).map(i => needs(i) * ps(i)).sum

    val dp = Array.fill(X + 1)(Int.MaxValue)

    val arrs = special.map(_.toArray).toArray

    val m = arrs.length

    val masks = Array.ofDim[Int](m)

    (0 until m) foreach (i => {
      val arr = arrs(i)
      var j = 0
      var tmp = 0
      while (j < n) {
        tmp += arr(j) * ps(j)
        j += 1
      }
      masks(i) = tmp
    })


    dp(0) = 0
    val cnt = Array.ofDim[Int](n)
    var state = 0
    while (state < X) {
      getCount(cnt, state, n)
      if (dp(state) < Int.MaxValue) {

        var i = 0
        while (i < n) {
          val next = state + ps(i)
          if (cnt(i) + 1 <= needs(i)) {
            // need to add one more
            dp(next) = dp(next) min (dp(state) + price(i))
          }
          i += 1
        }

        i = 0
        while (i < m) {
          val arr = arrs(i)

          val cost = arr(n)
          val next = state + masks(i)

          var j = 0
          while (j < n && cnt(j) + arr(j) <= needs(j)) {
            j += 1
          }

          if (j == n) {
            dp(next) = dp(next) min (dp(state) + cost)
          }

          i += 1
        }
      }

      state += 1
    }

    dp(X)
  }


}
