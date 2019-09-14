package set0000.set900.set930.p930

import scala.collection.mutable

object Solution {
  def numSubarraysWithSum(A: Array[Int], S: Int): Int = {
    val pos = mutable.Map.empty[Int, Int].withDefaultValue(0)
    pos(0) = 1
    var res = 0
    var sum = 0
    var i = 0
    while (i < A.length) {
      sum += A(i)
      res += pos(sum - S)
      pos(sum) += 1
      i += 1
    }
    res
  }

}
