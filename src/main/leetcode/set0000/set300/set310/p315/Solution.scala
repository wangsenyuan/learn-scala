package set0000.set300.set310.p315


object Solution {

  def countSmaller(nums: Array[Int]): List[Int] = {
    val n = nums.length
    val xx = nums.zipWithIndex.sortBy(_._1)
    val res = Array.ofDim[Int](n)

    val bit = new Bit(n)

    xx.foreach(p => {
      val (_, i) = p
      res(i) = bit.get(n - 1) - bit.get(i)
      bit.update(i, 1)
    })

    res.toList
  }

  class Bit(n: Int) {
    val arr = Array.ofDim[Int](n + 1)

    def update(i: Int, v: Int) = {
      var j = i + 1
      while (j <= n) {
        arr(j) += v
        j += (j & -j)
      }
    }

    def get(i: Int): Int = {
      var j = i + 1
      var res = 0
      while (j > 0) {
        res += arr(j)
        j -= (j & -j)
      }
      res
    }
  }

}
