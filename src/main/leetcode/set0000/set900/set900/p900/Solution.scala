package set0000.set900.set900.p900

object Solution {

  class RLEIterator(_A: Array[Int]) {
    var i = 0

    def next(n: Int): Int = {
      var cnt = 0
      while (i < _A.length && cnt + _A(i) < n) {
        cnt += _A(i)
        i += 2
      }
      if (i >= _A.length) {
        -1
      } else {
        // cnt + _A(i) >= n
        _A(i) -= n - cnt
        _A(i + 1)
      }
    }
  }

  /**
   * Your RLEIterator object will be instantiated and called as such:
   * var obj = new RLEIterator(A)
   * var param_1 = obj.next(n)
   */
}
