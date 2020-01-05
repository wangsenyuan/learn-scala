package set1000.set1200.set1290.p1299

object Solution {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    var cur = -1
    var i = arr.length - 1
    while (i >= 0) {
      val x = arr(i)
      arr(i) = cur
      cur = x max cur
      i -= 1
    }
    arr
  }
}
