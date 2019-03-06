package set400.set400.p409

object Solution {
  def longestPalindrome(s: String): Int = {
    val cnt = s.groupBy(identity).mapValues(_.size).map(_._2).toArray
    val x = cnt.filter(_ % 2 == 0).sum
    val y = cnt.filter(_ % 2 == 1)
    if(y.isEmpty) {
      x
    } else {
      x + y.map(_ - 1).sum + 1
    }
  }
}
