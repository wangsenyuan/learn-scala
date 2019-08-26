package set0000.set500.set560.p566

object Solution {
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    if (nums.length == 0 || nums(0).length == 0) {
      nums
    } else {
      val m = nums.length
      val n = nums(0).length
      if (m * n != r * c) {
        nums
      } else {
        val res = Array.ofDim[Int](r, c)
        val end = m * n
        var i = 0
        while (i < end) {
          val x = i / n
          val y = i % n
          val u = i / c
          val v = i % c
          res(u)(v) = nums(x)(y)
          i += 1
        }

        res
      }
    }
  }
}
