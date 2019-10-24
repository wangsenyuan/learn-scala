package set1000.set1000.set1010.p1016

import scala.collection.mutable

object Solution {
  def queryString(S: String, N: Int): Boolean = {

    if (N == 1) {
      S.contains('1')
    } else {
      val nums = mutable.Set.empty[Int]

      var i = 0
      while (i < S.length) {
        var num = 0
        var j = 1
        var valid = true
        while (i + j <= S.length && valid) {
          val x = S(i + j - 1) - '0'
          num = num * 2 + x
          if (num < 0 || num > N) {
            valid = false
          } else {
            nums += num
          }
          j += 1
        }

        i += 1
      }

      nums.size == N + 1
    }


  }
}
