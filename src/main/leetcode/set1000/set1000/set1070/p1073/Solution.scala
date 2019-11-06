package set1000.set1000.set1070.p1073

object Solution {
  def addNegabinary(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val m = arr1.length
    val n = arr2.length
    val l = (m max n) + 10
    val res = Array.ofDim[Int](l)

    var i = m - 1
    var j = n - 1
    var k = l - 1

    var carry = 0

    while (i >= 0 || j >= 0 || carry != 0) {
      if (i >= 0) {
        carry += arr1(i)
        i -= 1
      }
      if (j >= 0) {
        carry += arr2(j)
        j -= 1
      }
      res(k) = carry & 1
      k -= 1
      carry = -(carry >> 1)
    }

    val ans = res.dropWhile(_ == 0)
    if (ans.length == 0) {
      Array(0)
    } else {
      ans
    }
  }
}
