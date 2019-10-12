package set0000.set900.set980.p983

object Solution {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val dp = Array.fill[Int](400)(Int.MaxValue)

    // dp(i) is the cost reaching at day i
    dp(0) = 0

    val n = days.length

    var i = 0
    var x = 1
    while (x < 366 && i < n) {
      if (x == days(i)) {
        // x == days(i)
        (0 until 1).foreach(j => dp(x + j) = dp(x + j) min (dp(x - 1) + costs(0)))
        (0 until 7).foreach(j => dp(x + j) = dp(x + j) min (dp(x - 1) + costs(1)))
        (0 until 30).foreach(j => dp(x + j) = dp(x + j) min (dp(x - 1) + costs(2)))

        i += 1
      } else {
        dp(x) = dp(x) min dp(x - 1)
      }

      x += 1
    }

    dp(days(n - 1))
  }
}
