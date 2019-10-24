package set1000.set1000.set1010.p1015

object Solution {
  def smallestRepunitDivByK(K: Int): Int = {
    if (K % 2 == 0 || K % 5 == 0) {
      -1
    } else {
      var cnt = 1
      var num = 1
      while (num % K != 0) {
        num = (num * 10 + 1) % K
        cnt += 1
      }
      cnt
    }
  }
}
