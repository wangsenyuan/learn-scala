package set1000.set1300.set1350.p1352

class ProductOfNumbers {
  val MAX_K = 40007
  val array = Array.fill(2 * MAX_K)(1L)
  var index = 0

  private def update(pos: Int, v: Int): Unit = {
    var p = pos + MAX_K
    array(p) = v

    while (p > 0) {
      array(p >> 1) = array(p) * array(p ^ 1)
      p >>= 1
    }
  }

  def add(num: Int) {
    update(index, num)
    index += 1
  }

  def getProduct(k: Int): Int = {
    var r = index
    var l = index - k

    r += MAX_K
    l += MAX_K
    var res = 1L
    while (l < r) {
      if ((l & 1) == 1) {
        res *= array(l)
        l += 1
      }

      if ((r & 1) == 1) {
        r -= 1
        res *= array(r)
      }
      l >>= 1
      r >>= 1
    }

    res.toInt
  }
}
