package set1000.set1000.set1040.p1047

import scala.collection.mutable.ArrayBuffer

object Solution {
  def removeDuplicates(S: String): String = {
    val arr = S.toCharArray
    val n = arr.length

    val stack = Array.ofDim[Int](n)
    var p = 0
    var i = 0
    while (i < n) {
      var remove = false
      while (p > 0 && arr(stack(p - 1)) == arr(i)) {
        remove = true
        p -= 1
      }

      if (!remove) {
        stack(p) = i
        p += 1
      }
      i += 1
    }
    val res = ArrayBuffer.empty[Char]
    i = 0
    while (i < p) {
      res += arr(stack(i))
      i += 1
    }

    res.mkString("")
  }
}
