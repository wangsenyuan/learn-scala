package set700.set770.p779

object Solution {
  def kthGrammar(N: Int, K: Int): Int = {

    def loop(n: Int, k: Int): Int = {
      if(n == 0) {
        0
      } else {
        val a = loop(n - 1, k >> 1)
        if(k % 2 == 0) {
          a
        } else {
          1 - a
        }
      }
    }

    loop(N - 1, K - 1)
  }
}
