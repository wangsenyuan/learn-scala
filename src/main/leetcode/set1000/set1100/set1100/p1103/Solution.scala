package set1000.set1100.set1100.p1103

object Solution {
  // first one get 1, n + 1, 2 * n + 1, ... x * n + 1 => x + 1 + (0 * n + 1 * n + 2 * n + ... x * n) => n + n * (0 + 1 + ... + x) => x + 1 + n * (0 + x) * (x + 1) / 2
  // second one get 2, n + 2, 2 * n + 2, ... x * n + 2 => 2 * (x + 1) + n * (x) * (x + 1) / 2
  // i th person get i, n + i, 2 * n + i, .... x * n + i => i * (x + 1) + n * x * (x + 1) / 2
  // n one get n, n + n, 2 * n + n, ... x * n + n => n * (x + 1) + n * ( x) * (x + 1) / 2
  // =>  n * n * (x) * (x + 1) / 2 + (x + 1) * (1 + 2  + ... + n) => n * n * (x) * (x + 1) / 2 + (x + 1) * n * (n + 1) / 2
  def distributeCandies(candies: Int, num_people: Int): Array[Int] = {
    val n = num_people.toLong

    def count(x: Int): Long = {
      n * n * x * (x + 1) / 2 + (x + 1) * n * (n + 1) / 2
    }

    val res = Array.ofDim[Int](num_people)

    val x = search(10000, count(_) > candies)
    // count(x) <= candies
    if (x == 0) {
      var total = candies
      var i = 1
      while (total > 0) {
        res(i - 1) = i min total
        total -= res(i - 1)
        i += 1
      }
    } else {
      // x > 1, try distribute x - 1 round first, then try last one
      val y = x - 1
      var total = candies
      var i = 0
      while (i < n) {
        res(i) = (i + 1) * (y + 1) + num_people * y * (y + 1) / 2
        total -= res(i)
        i += 1
      }
      i = 0
      while (total > 0) {
        val tmp = (num_people * x + i + 1) min total
        res(i) += tmp
        total -= tmp
        i += 1
      }
    }

    res
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
