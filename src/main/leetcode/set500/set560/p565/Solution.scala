package set500.set560.p565

object Solution {
  def arrayNesting(nums: Array[Int]): Int = {
    val n = nums.length
    val colors = Array.fill(n)(-1)
    val count = Array.ofDim[Int](n)

    def visit(i: Int, color: Int) = {
      var slow = i
      var fast = i
      do {
        slow = nums(slow)
        fast = nums(nums(fast))
      } while(slow != fast && colors(slow) < 0)

      if(colors(slow) < 0) {
        do {
          colors(slow) = color
          count(color) += 1
          slow = nums(slow)
        } while(slow != fast)
      }
    }

    var i = 0
    while(i < n) {
      if(colors(i) < 0) {
        visit(i, i)
      }
      i += 1
    }


    def calc(i: Int): Int = {
      var j = i
      var res = 0
      while(colors(j) < 0) {
        res += 1
        j = nums(j)
      }
      res += count(colors(j))
      res
    }

    var ans = 0
    i = 0
    while(i < n) {
      ans = ans max calc(i)
      i += 1
    }

    ans
  }
}
