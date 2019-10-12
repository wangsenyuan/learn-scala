package set0000.set900.set980.p989

import scala.collection.mutable.ArrayBuffer

object Solution {
  def addToArrayForm(A: Array[Int], K: Int): List[Int] = {
    val n = A.length
    if (n < 10) {
      val num = toInt(A) + K
      toArray(num).toList
    } else {
      val B = toArray(K)
      // B.length < A.length

      val res = Array.ofDim[Int](n + 1)
      var i = n - 1
      var j = B.length - 1
      var k = n
      var carry = 0
      while (i >= 0 && j >= 0) {
        res(k) = A(i) + B(j) + carry
        if (res(k) >= 10) {
          res(k) -= 10
          carry = 1
        } else {
          carry = 0
        }
        i -= 1
        j -= 1
        k -= 1
      }
      while (i >= 0) {
        res(k) = A(i) + carry
        if (res(k) >= 10) {
          res(k) -= 10
          carry = 1
        } else {
          carry = 0
        }
        i -= 1
        k -= 1
      }
      if (carry > 0) {
        res(k) = carry
        k -= 1
      }
      if (k == 0) {
        res.drop(1).toList
      } else {
        res.toList
      }
    }
  }

  private def toInt(arr: Array[Int]): Int = {
    var res = 0
    var i = 0
    while (i < arr.length) {
      res = res * 10 + arr(i)
      i += 1
    }
    res
  }

  private def toArray(num: Int): Array[Int] = {
    if (num == 0) {
      Array(0)
    } else {
      var x = num
      val buf = ArrayBuffer.empty[Int]
      while (x > 0) {
        buf += x % 10
        x /= 10
      }

      buf.reverse.toArray
    }
  }

}
