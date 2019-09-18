package set0000.set900.set940.p948

import scala.util.Sorting

object Solution {
  def bagOfTokensScore(tokens: Array[Int], P: Int): Int = {
    val n = tokens.length

    Sorting.quickSort(tokens)

    var power = P
    var points = 0
    var ans = 0
    var i = 0
    var j = n - 1
    while (i <= j) {
      if (points > 0 && power < tokens(i)) {
        points -= 1
        power += tokens(j)
        j -= 1
      }
      if (i <= j && power >= tokens(i)) {
        points += 1
        power -= tokens(i)
        i += 1
      } else if (points > 0) {
        // no problem
      } else {
        // break
        i = j + 1
      }
      ans = ans max points
    }

    ans
  }

}
