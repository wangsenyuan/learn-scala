package set500.set500.p503

object Solution {
  def nextGreaterElements(nums: Array[Int]): Array[Int] = {
    val arr = nums ++ nums
    val n = arr.length
    val right = Array.fill(n)(-1)
    var i = 0
    val stack = Array.fill(n)(-1)
    var p = 0
    while(i < n) {
      while(p > 0 && arr(stack(p-1)) < arr(i)) {
        right(stack(p-1)) = i
        p -= 1
      }
      stack(p) = i
      p += 1
      i += 1
    }

    val res = Array.fill(n/2)(-1)
    i = 0
    while(i < res.length) {
      if(right(i) >= 0) {
        res(i) = arr(right(i))
      }
      i += 1
    }
    res
  }
}
