package set0000.set600.set690.p696


object Solution {
  def countBinarySubstrings(s: String): Int = {
    val n = s.length
    val cnt = Array.ofDim[Int](n)
    var j = 0
    var k = 0
    var i = 1
    while(i <= n) {
      if(i == n || s(i) != s(i-1)) {
        cnt(j) = i - k
        j += 1
        k = i
      }
      i += 1
    }
    val nums = cnt.take(j)
    val res = nums.zip(nums.tail).map(x => x._1 min x._2).sum
    res
  }
}
