package set200.set200.p201

object Solution {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    var a = m
    var b = n
    var c = 0
    while (a != b) {
      a >>= 1
      b >>= 1
      c += 1
    }
    a << c
  }
}
