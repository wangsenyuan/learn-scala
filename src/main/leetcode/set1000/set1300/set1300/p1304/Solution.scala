package set1000.set1300.set1300.p1304

object Solution {
  def sumZero(n: Int): Array[Int] = {
    val arr = Array.ofDim[Int](n)
    var i = 0
    var j = n - 1
    var x = -(n + 1)
    var y = n + 1
    while (i < j) {
      arr(i) = x
      arr(j) = y
      i += 1
      j -= 1
      x += 1
      y -= 1
    }
    arr
  }
}
