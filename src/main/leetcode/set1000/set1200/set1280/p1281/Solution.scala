package set1000.set1200.set1280.p1281

object Solution {
  def subtractProductAndSum(n: Int): Int = {
    val digits = n.toString.toCharArray.map(x => (x - '0'))
    val prod = digits.product
    val sum = digits.sum
    prod - sum
  }
}
