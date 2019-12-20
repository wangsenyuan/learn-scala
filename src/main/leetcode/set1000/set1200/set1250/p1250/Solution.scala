package set1000.set1200.set1250.p1250

object Solution {
  def isGoodArray(nums: Array[Int]): Boolean = {
    val g = nums.reduce(gcd)
    g == 1
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
