package set0000.set700.set760.p769

object Solution {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    var ans = 0
    val n = arr.length
    var end = 0
    var i = 0
    while(i < n) {
      if(i > end) {
        ans += 1
      }
      end = end max arr(i)
      i += 1
    }
    ans += 1
    return ans
  }
}
