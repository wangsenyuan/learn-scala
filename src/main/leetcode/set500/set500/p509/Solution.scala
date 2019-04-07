package set500.set500.p509

object Solution {
  def fib(N: Int): Int = {
    def go(a: Int, b: Int, i: Int): Int = {
      if(i == N) {
        a
      } else {
        go(b, a + b, i + 1)
      }
    }
    go(0, 1, 0)
  }
}
