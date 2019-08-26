package set0000.set700.set770.p771

object Solution {
  def numJewelsInStones(J: String, S: String): Int = {
    val f = J.toSet
    S.count(f)
  }
}
