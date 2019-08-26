package set0000.set700.set780.p781

import scala.util.Sorting

object Solution {
  def numRabbits(answers: Array[Int]): Int = {
    val n = answers.length
    if(n == 0) {
      0
    } else {
      Sorting.quickSort(answers)
      var res = 0
      var i = 1
      var j = 0
      while(i <= n) {
        if(i == n || answers(i) > answers(i - 1) || (i - j >= 1 + answers(i - 1))) {
          res += answers(i - 1) + 1
          j = i
        }

        i += 1
      }

      res
    }
  }
}
