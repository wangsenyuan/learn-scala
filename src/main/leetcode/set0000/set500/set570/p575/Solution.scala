package set0000.set500.set570.p575

object Solution {
  def distributeCandies(candies: Array[Int]): Int = {
    val set = candies.toSet

    val m = candies.length
    val half = m / 2
    val n = set.size

    n min half
  }
}
