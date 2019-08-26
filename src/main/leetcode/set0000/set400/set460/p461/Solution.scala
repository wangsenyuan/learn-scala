package set0000.set400.set460.p461

object Solution {
  def hammingDistance(x: Int, y: Int): Int = {
    var i = 0
    var res = 0
    while(i < 32) {
      val a = (x >> i) & 1
      val b = (y >> i) & 1
      res += a ^ b
      i += 1
    }
    res
  }
}
