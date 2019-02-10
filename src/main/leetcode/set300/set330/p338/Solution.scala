package set300.set330.p338

object Solution {
  def countBits(num: Int): Array[Int] = {
    if (num == 0) {
      Array(0)
    } else {
      val arr = Array.ofDim[Int](num + 1)
      var i = 1
      while (i <= num) {
        arr(i) = arr(i / 2) + (i & 1)
        i += 1
      }
      arr
    }
  }
}
