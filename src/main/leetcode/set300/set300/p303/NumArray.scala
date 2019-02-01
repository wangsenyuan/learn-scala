package set300.set300.p303

class NumArray(_nums: Array[Int]) {
  val n = _nums.length
  val sums = Array.ofDim[Int](n + 1)

  (1 to n) foreach {
    i => sums(i) = sums(i - 1) + _nums(i - 1)
  }

  def sumRange(i: Int, j: Int): Int = {
    sums(j + 1) - sums(i)
  }

}
