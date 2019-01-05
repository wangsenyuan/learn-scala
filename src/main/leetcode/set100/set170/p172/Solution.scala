package set100.set170.p172

object Solution {
  def trailingZeroes(n: Int): Int = {
    val num = n.toLong
    var exp = 5L
    var ans = 0L
    while (num >= exp) {
      ans += num / exp
      exp *= 5
    }

    ans.toInt
  }
}
