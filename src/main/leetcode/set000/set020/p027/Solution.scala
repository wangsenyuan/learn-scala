package set000.set020.p027

object Solution {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var j = 0
    var i = 0
    while (i < nums.length) {
      if (nums(i) != `val`) {
        nums(j) = nums(i)
        j += 1
      }
      i += 1
    }
    j
  }
}
