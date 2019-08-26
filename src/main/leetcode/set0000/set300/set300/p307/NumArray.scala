package set0000.set300.set300.p307

class NumArray(_nums: Array[Int]) {

  val n = _nums.length

  val bit = Array.ofDim[Int](n + 1)

  private def add(i: Int, v: Int): Unit = {
    var j = i + 1
    while (j <= n) {
      bit(j) += v
      j += j & (-j)
    }
  }

  (0 until n) foreach (i => add(i, _nums(i)))

  def update(i: Int, `val`: Int) {
    val diff = `val` - _nums(i)
    add(i, diff)
    _nums(i) = `val`
  }

  private def sum(i: Int): Int = {
    var j = i + 1
    var res = 0
    while (j > 0) {
      res += bit(j)
      j -= j & (-j)
    }
    res
  }

  def sumRange(i: Int, j: Int): Int = {
    sum(j) - sum(i - 1)
  }

}
